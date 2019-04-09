package com.bigtalkdatastruct.linearlist;

public class LinkedList<T>{
    public static class Node<T> {
        private T data;
        private Node next;

        public Node(T t, Node next) {
            this.data = t;
            this.next = next;
        }

        public T getData() {
            return data;
        }
        public Node getNext() {
            return next;
        }
    }

    private Node<T> head = null;

    public LinkedList() {
    }

    public boolean empty() {
        return head == null;
    }

    public Node<T> getElemByIndex(int index) {
        Node<T> node = head;
        while (node != null && index > 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    public Node<T> getElemByValue(T value) {
        Node<T> node = head;
        while (node != null && value != node.data) {
            node = node.next;
        }
        return node;
    }

    public void insertToHead(T e) {
        Node<T> node = new Node<>(e, null);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void insertToTail(T e) {
        Node<T> node = new Node<>(e, null);
        if (head == null) {
            head = node;
        } else {
            Node<T> p = head;
            while (p.next != null) {
                p = p.next;
            }
            //注意这里很关键⚠️
            node.next = p.next;
            p.next = node;
        }
    }

    public void insertAfter(Node<T> p, T e) {
        Node<T> node = new Node<>(e, null);
        if (p == null) {
            return;
        }
        node.next = p.next;
        p.next = node;
    }

    public void insertBefore(Node<T> p, T e) {
        Node<T> node = new Node<>(e, null);
        if (p == null) {
            return;
        }
        if (head == p) {
            insertToHead(e);
            return;
        }

        Node<T> q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        //先把后面的节点链接上，之后再链接前面的节点
        node.next = p;
        q.next = node;
    }

    public void deleteByNode(Node<T> node) {
        if (node == null || head == null) {
            return;
        }

        //删头
        if (node == head) {
            head = head.next;
            return;
        }

        Node<T> p = head;
        while (p != null && p.next != node) {
            p = p.next;
        }
        if (p == null) {
            return;
        }

        p.next = p.next.next;
        node.next = null;
    }

    public void deleteByValue(T e) {
        if (head == null) {
            return;
        }
        if (head.data == e) {
            head = head.next;
        }
        Node<T> p = head;
        while (p != null) {
            if (p.next != null && p.next.data == e) {
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }

    }

    public int size() {
        if (head == null) {
            return 0;
        }
        Node<T> node = head;
        int i = 0;
        while (node != null) {
            node = node.next;
            i ++;
        }
        return i;
    }

    public void print() {
        if (head == null) {
            System.out.println("head is null.");
        }
        Node<T> node = head;
        while (node != null) {
            System.out.print("node=" + node.data +" ");
            node = node.next;
        }
        System.out.println();
    }

    //判断是否为回文1-2-3-5-3-2-1
    public boolean palindrome() {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }

        Node<T> p = findMiddleNode();
        //反转链表
        p = inverse(p.next);

        while (p!= null) {
            System.out.print("p:" + p.data + ", head:" + head.data);
            System.out.println();
            if (p.data != head.data) {
                return false;
            }
            p = p.next;
            head = head.next;
        }

        return true;
    }

    //找到中间节点
    public Node<T> findMiddleNode() {
        Node<T> p = head;
        Node<T> q = head;
        //找到中间节点
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        System.out.println("中间节点:" + p.data);
        return p;
    }

    //链表反转
    public Node<T> inverse(Node<T> head) {
        if (head == null) {
            return null;
        }

        Node<T> cur = head;
        Node<T> pre = null;
        while (cur != null) {
            Node<T> next = cur.next; //暂存下一个节点
            cur.next = pre; //下个节点的next指向pre
            pre = cur;  //pre指向cur
            cur = next;
        }
        return pre;
    }

    //判断链表是否有环

    //找到两条链表交点
//    链表排序；
//    合并两个有序链表；
//    求出链表倒数第k个值；
//    判断链表是否有环，有环返回相遇结点；
//    在一个有环链表中找到环的入口；
}
