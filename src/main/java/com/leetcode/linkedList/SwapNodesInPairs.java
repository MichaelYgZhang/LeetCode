package com.leetcode.linkedList;

import com.leetcode.common.ListNode;

/**
 * 交换链表的两个相邻节点
 * 1->2->3->4->null
 * 2->1->4->3->null
 * 或者
 * 1->2->3->null
 * 2->1->3->null
 */
public class SwapNodesInPairs {
    public static ListNode swapNodesInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        while (head != null && head.next != null) {
            ListNode curHead = head.next.next;
            ListNode a = new ListNode(head.val);
            ListNode b = new ListNode(head.next.val);
            b.next = a;
            //尾插法
            newHead = tailInsert(newHead, b);
            head = curHead;
        }
        if (head == null) {
            return newHead;
        }
        if (head.next == null) {
            newHead = tailInsert(newHead, head);
        }
        return newHead;
    }
    //尾插法
    private static ListNode tailInsert(ListNode head, ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode tempNode = head;
            while (head.next != null) {
                head = head.next;
            }
            head.next = node;
            head = tempNode;
        }
        return head;
    }

    //opt
    public ListNode swapNodesInPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

}
