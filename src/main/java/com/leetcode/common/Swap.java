package com.leetcode.common;

public class Swap {
    public static void swapArray(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
