package com.leetcode.search;

/**
 * 二分查找
 */
public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int resutl = Integer.MAX_VALUE;
        int low = 0;
        int height = array.length - 1;
        while (low <= height) {
            int mid = (low + height) / 2;
            int temp = array[mid];
            if (temp == target) {
                return mid;
            } else if (temp < target) {
                low = mid + 1;
            } else if (temp > target) {
                height = mid -1;
            }
        }
        return resutl;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9};
        System.out.printf("%d", binarySearch(array, 5));
    }
}
