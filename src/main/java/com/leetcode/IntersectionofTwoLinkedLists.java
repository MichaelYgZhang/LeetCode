package com.leetcode;

import com.leetcode.common.ListNode;

/**
 * 找出两个链表的交叉点
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * 返回 c1
 * 思路: 遍历循环a,b两个链表, 如果a走到头了,则a= headB, 如果是b走到尾部，则 b= headA; 两次循环就能找到c1
 *
 */
public class IntersectionofTwoLinkedLists {
    public static ListNode getIntersectionListNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode c1 = new ListNode(4);
        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(2);
        a.next = a1;
        a1.next = c;
        c.next = c1;
        b.next = b1;
        b1.next = c;
        c.next = c1;
        final ListNode intersectionListNode = getIntersectionListNode(a, b);

        System.out.println(intersectionListNode == null ? "null" : intersectionListNode.val);
    }
}

