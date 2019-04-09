package com.bigtalkdatastruct.linearlist;

import org.junit.Test;

public class LinedListTest {

    @Test
    public void test_linkedList() {
        int data[] = {1,2,3};
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            linkedList.insertToTail(data[i]);
//            linkedList.insertToHead(data[i]);
        }

//        linkedList.print();
//        linkedList.deleteByValue(5);
//        System.out.println();
//        linkedList.print();
//        System.out.println();
//        linkedList.deleteByNode(linkedList.getElemByValue(2));
        linkedList.print();

//        System.out.println(linkedList.palindrome());

        LinkedList.Node node = linkedList.inverse(linkedList.getElemByIndex(0));
        while (node != null) {
            System.out.print("node=" + node.getData() +" ");
            node = node.getNext();
        }
    }
}
