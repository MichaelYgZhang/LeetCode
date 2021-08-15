package com.search;

public class BinarySearch {

    /**
     * 非递归方式:
     * 1. 循环的判定条件是：low <= high
     * 2. 为了防止数值溢出，mid = low + (high - low)/2
     * 3. 当 A[mid]不等于target时，high = mid - 1或low = mid + 1
     * 时间复杂度: O(log2n) 空间O(1)
     */
    public static int binarySearch(int x, int[] ary) {
        int low = 0;
        int hight = ary.length - 1;

        while (low <= hight) {
            int mid = low + (hight - low)/2; //注意：若使用(low+high)/2求中间位置容易溢出
            int t = ary[mid];
            if (t == x) {
                return t;
            } else if (t < x) {
                low = mid + 1;
            } else {
                hight = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ary = {1, 2, 3, 4};
        System.out.println(binarySearch(6, ary));
    }
}
