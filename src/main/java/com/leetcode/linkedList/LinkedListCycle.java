package com.leetcode.linkedList;

import com.leetcode.common.ListNode;

/**
 * 涉及题目
 * 1. 判断链表是否有环
 * 2. 如何找到环链表的第一个节点?
 * 3. 两条链表是否相交？如果相交则返回交点
 * 4. 如何将有环链表修改为单链链表?
 */
public class LinkedListCycle {
    /**
     * 1. 判断一个单链表是否有环
     * 思路: 两个指针，一个一步，一个两步，如果有相等的情况则是循环链表，否则不是。
     */
    public static boolean hasCycle(ListNode listNode) {
        if (listNode == null) {
            return false;
        }
        ListNode oneStep = listNode;
        ListNode twoStep = listNode;
        while (twoStep.next != null && twoStep.next.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep) {
                return true;
            }
        }
        return false;
    }

    /**
     * 2. 找到有环链表的第一个节点
     * 思路: 1. 判断有环？
     *      2. 有环时令slow从头开始遍历链表，而快的则继续从当前节点开始，只是从此以后每次只执行一步，如果再次相遇则就是环的第一个节点
     *
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //1. 判断有环?
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //如果相等则有环
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 3. getIntersectionNode 找到两条链表的相交点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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

}

