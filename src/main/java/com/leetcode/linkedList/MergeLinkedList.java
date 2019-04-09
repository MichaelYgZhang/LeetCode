package com.leetcode.linkedList;

import com.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1. 合并两个有序链表
 * 2. 合并多个有序链表集合
 */
public class MergeLinkedList {
    /**
     * a: 1- > 2 - > 3 -> 6
     * b: 4 -> 5
     * output: 1 - > 2 - > 3 -> 4 -> 5 -> 6
     */
    public static ListNode mergeTwoLists2(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode newHead = new ListNode(0);
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                ListNode temp1 = head1.next;
                newHead = tailInsert(newHead, new ListNode(head1.val));
                head1 = temp1;
            } else {
                ListNode temp2 = head2.next;
                newHead = tailInsert(newHead, new ListNode(head2.val));
                head2 = temp2;
            }
        }
        if (head1 == null) {
            newHead = tailInsert(newHead, head2);
        } else {
            newHead = tailInsert(newHead, head1);
        }
        return newHead.next;
    }

    public static ListNode tailInsert(ListNode head, ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (head.next != null) {
                head = head.next;
            }
            head.next = node;
            head = temp;
        }
        return head;
    }


    public static ListNode mergeTwoLists(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if (head1 != null) {
            curr.next = head1;
        }
        if (head2 != null) {
            curr.next = head2;
        }
        return result.next;
    }

    /**
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     * 思路: 1. 两个两个排序 n*nlog(n)  452 ms
     *      2. 连接起来，做个排序算法, 归并排序 n + nlog(n) 145 ms
     *      3.
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode newHead = null;
        for (ListNode node : lists) {
            newHead = mergeTwoLists(newHead, node);
        }
        return newHead;
    }

    /**
     * 1. 所有链表连接起来
     * 2. 然后统一进行归并排序
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode newHead = null;
        for (ListNode node : lists) {
            if (node == null) continue;
            if (newHead == null && node != null) {
                newHead = node;
            } else {
                newHead = tailInsert(newHead, node);
            }
        }
        return LinkedListSort.mergeSort(newHead);
    }

    /**
     * 优先队列方式
     *
     * @return
     */
    public static ListNode mergeKLists3(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if ((Integer)o1.val<(Integer)o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null){
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }
}

