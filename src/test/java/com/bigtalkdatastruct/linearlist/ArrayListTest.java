package com.bigtalkdatastruct.linearlist;

import org.junit.Test;

public class ArrayListTest {

    @Test
    public void test_insert() {
        ListADT<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            arrayList.insert(i);
        }
        arrayList.print();
        System.out.println("====delete..start.");
        arrayList.delete(arrayList.size() - 2);
        arrayList.print();
        System.out.println("=====delete..end.");
        arrayList.insert(0, 99);
        arrayList.print();
        System.out.println("=====insert..1.");
        arrayList.insert(0, 99);
        arrayList.print();
    }
}
