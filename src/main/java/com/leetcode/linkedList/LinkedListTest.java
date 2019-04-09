package com.leetcode.linkedList;

import com.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListTest {
    private static ListNode builderLinkedList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        return listNode1;
    }
    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static void main(String[] args) {
//        Node listNode = builderLinkedList();
        //链表交换
//        Node list = ReverseLinkedList.reverse(listNode);
//        Node list = SwapNodesInPairs.swapNodesInPairs(listNode);
//        printLinkedList(list);

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);
        l31.next = l32;
//        final Node listNode = MergeLinkedList.mergeTwoLists(l1, l21);

//        [[1,4,5],[1,3,4],[2,6]]
//        final Node listNode = MergeLinkedList.mergeKLists2(listNodes);
        List<ListNode> listNodeList = new ArrayList<ListNode>();
        listNodeList.add(l1);
        listNodeList.add(l21);
        listNodeList.add(l31);
        final ListNode listNode = MergeLinkedList.mergeKLists3(listNodeList);
//        final Node listNode = LinkedListSort.bubbleSort(l1);
//        LinkedListSort.mergeSort(l1);
        printLinkedList(listNode);
    }
}
