package com.base.algorithms.sort;

import java.util.Arrays;


public class SelectSort {
    /**
     * 它的工作原理是每一次从待排序的数据元素中选出最小（或最大）的一个元素，
     * 存放在序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
     * 然后放到已排序序列的末尾。以此类推，直到全部待排序的数据元素排完。
     * 选择排序是不稳定的排序方法
     */
    public static void selectSort(int[] ary) {
        for (int i = 0, selectTimes = ary.length; i < selectTimes; i++) {
            int min = i;
            for (int j = i + 1; j < selectTimes; j++) {
                if (ary[j] < ary[min]) {
                    min = j;
                }
            }
            //交互
            int temp = ary[i];
            ary[i] = ary[min];
            ary[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ary = {3, 2, 4, 5, 1};
        selectSort(ary);
        System.out.println(Arrays.toString(ary));
    }
}
