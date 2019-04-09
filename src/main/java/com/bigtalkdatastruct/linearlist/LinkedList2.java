package com.bigtalkdatastruct.linearlist;

//Pass
public class LinkedList2 {
    static class Node {
        private Node next;
        private int v;
        public Node(int x) {
            this.v = x;
        }
    }

    private Node head;
    private int size;
    /** Initialize your data structure here. */
    public LinkedList2() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node h = head;
        while (index > 0) {
            index--;
            h = h.next;
        }
        return h.v;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        size++;
        Node n = new Node(val);
        if (head == null) {
            head = n;
            return;
        }
        n.next = head;
        head = n;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        size++;
        Node n = new Node(val);
        if (head == null) {
            head = n;
            return;
        }
        Node h = head;
        while(h.next != null) {
            h = h.next;
        }
        h.next = n;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else {
            Node cur = head;
            while (--index > 0) {
                cur = cur.next;
            }
            Node newNode = new Node(val);
            newNode.next = cur.next;
            cur.next = newNode;
            size++;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        Node prev = head;
        while (--index > 0) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
    }

    public static void main(String[] args) {
//        ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//[[],[1],[3],[1,2],[1],[1],[1]]

        LinkedList2 linkedList = new LinkedList2();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        System.out.println(linkedList.get(1));            // returns 2
        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        System.out.println(linkedList.get(1));;            // returns 3



        //        ["MyLinkedList","get","addAtIndex","get","get","addAtIndex","get","get"]
//[[],[0],[1,2],[0],[1],[0,1],[0],[1]]
//        System.out.println(linkedList.get(0));
//        linkedList.addAtIndex(1, 2);
//        System.out.println(linkedList.get(0));;
//        System.out.println(linkedList.get(1));;
//        linkedList.addAtIndex(0, 1);
//        System.out.println(linkedList.get(0));;
//        System.out.println(linkedList.get(1));;


//        ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//[[],[1],[3],[1,2],[1],[1],[1]]
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
