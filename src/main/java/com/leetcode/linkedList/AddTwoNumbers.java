package com.leetcode.linkedList;

import com.leetcode.common.ListNode;

/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 思路: 与两个2机制相加思路类似
 */
public class AddTwoNumbers {
    public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> prev = new ListNode<>(0);
        ListNode head = prev;
        int tempSum = 0;//记录两两相加的进位值
        while (l1 != null || l2 != null || tempSum >= 1) {
            ListNode<Integer> curr = new ListNode<>(0); //创建当前节点
            int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + tempSum;
            curr.val = sum % 10;
            tempSum = sum / 10;
            prev.next = curr;
            prev = curr; //注意移动指针
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;

        }
        return head.next;
    }
}
