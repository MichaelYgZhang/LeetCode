package com.leetcode.linkedList;

import com.leetcode.common.ListNode;

/**
 * 翻转链表
 * 1->2->3->4->5->null
 * 5->4->3->2->1->null
 */
public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next; //暂存下一次遍历的节点
            //便于理解的处理
//            Node tempNode = new Node(head.val); //创建临时新的节点
//            tempNode.next = newHead; // 头插法到新倒叙节点
//            newHead = tempNode; //移动头指针
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
