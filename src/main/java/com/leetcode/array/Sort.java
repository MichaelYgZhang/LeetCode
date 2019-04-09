package com.leetcode.array;

import com.leetcode.common.Swap;

import java.util.Arrays;

/**
 * 1. 快速排序
 */
public class Sort {
    /**
     * 快排序思想：
     *      找到一个基准点，比如第一个元素，
     * @param a
     * @param l
     * @param r
     */
    public static void quickSort(int[] a, int l, int r) {
        if (l > r) {
            return;
        }
        int x = a[l];
        int i = l, j = r;
        while (i < j) {
            while (i < j && a[j] >= x) { //从右向左找到第一个小于x的值
                j--;
            }
            if (i < j) {
                Swap.swapArray(a, i, j);
                i++;
            }
            while (i < j && a[i] < x) { //从左向右找到第一个大于x的值
                i++;
            }
            if (i < j) {
                Swap.swapArray(a, i, j);
                j--;
            }
        }
        quickSort(a, l, i -1);
        quickSort(a, i+1, r);
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3, 5, 6};
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
