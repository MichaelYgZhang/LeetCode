package com.leetcode.DP;

/**
 * input : arr = [1, 2, 3, 34, 12, 5, 2], S = 9
 * 问arr中是否存在累加为S的数字，存在返回true, 否则false
 */
public class DP_GetSubset {
    /**
     * 递归
     * @param arr
     * @param i
     * @param s
     * @return
     */
    private static boolean rec_subset(int[] arr, int i, int s) {
        if (s == 0) {
            return true;
        } else if (i == 0) {
            return arr[i] == s;
        } else if (arr[i] > s) {
            return rec_subset(arr, i -1, s);
        } else {
            boolean X = rec_subset(arr, i -1, s - arr[i]);
            boolean Y = rec_subset(arr, i -1, s);
            return X || Y;
        }
    }

    /**
     * 非递归
     */
    //TODO

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        System.out.println(rec_subset(arr, arr.length - 1, 9));

    }
}
