package com.leetcode.linkedList;

import com.leetcode.common.ListNode;

/**
 * 每K个数据交换翻转节点,举例: 1->2->3->4->5->null
 * k=2, output: 2->1->4->3->5->null
 * k=3, output: 3->2->1->4->5->null
 */
// TODO
public class ReverseNodesInKGroup {
    public static ListNode reverseNodesInKGroup(ListNode head, int k) {
        if (head == null || k < 1) {
            return head;
        }
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
            if (len < k) {
                return null;
            }
        }

        ListNode newHead = null;
        ListNode tempHead = null;
        while (head != null) {
            tempHead = head;
            int x = 0;
            while (x <= k && head!= null) {
                x++;
                ListNode temp = head.next;
                head.next = newHead;
                newHead = head;
                head = temp;
            }
            head = tempHead;
        }

        return newHead;
    }
}
