package com.leetcode.linkedList;

import com.leetcode.common.ListNode;

/**
 * 链表排序，冒泡排序？快排？
 */
public class LinkedListSort {
    //冒泡
    public static ListNode bubbleSort(ListNode<Integer> listNode) {
        ListNode p, q;
        for (p = listNode; p != null; p = p.next) {
            for (q = p.next; q != null; q = q.next) {
                Integer pV = (Integer)p.val;
                Integer qV = (Integer)q.val;
                if (pV > qV) {
                    int temp = pV;
                    p.val = qV;
                    q.val = temp;
                }
            }
        }
        return listNode;
    }
    //归并排序
    public static ListNode mergeSort(ListNode<Integer> head) {
        //1. 找到中间节点
        //2. 归并
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        return mergeSort(mergeSort(head), mergeSort(right));
    }

    private static ListNode getMid(ListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode mergeSort(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (head1 != null && head2 != null) {
            if ((Integer)head1.val <= (Integer)head2.val) {
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

}
