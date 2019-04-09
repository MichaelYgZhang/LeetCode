package com.leetcode.DP;

import static java.lang.Math.max;

/**
 * input: arr:  4, 1, 1, 9, 1
 * output: 4+9 = 13
 * desp: 给一组数字，两个相邻的数字只能选取一个，举例来说: 选了arr[0], 就不能选取arr[1], 最后选出最大的数字和, 比如最后选出 4 + 9 为最大数字
 * 思考: 最后得出如下表达式: opt(i) = max ( opt(i-1), arr[i] + opt(i - 2) 其中: opt(0)=arr[0], opt(1)=max(arr[0], arr[1]);
 */
public class DP_GetMaxValue {

    /**
     * 递归方式
     */
    private static int recursion(int[] arr, int i) {
        if (i == 0) {
            return arr[0];
        } else if (i == 1) {
            return max(arr[0], arr[1]);
        } else {
            int valueY = recursion(arr, i - 2) + arr[i];
            int valueX = recursion(arr, i - 1);
            return max(valueX, valueY);
        }
    }

    /**
     * 非递归方式
     */
    private static int dp_opt(int[] arr) {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int valueY = opt[i - 2] + arr[i];
            int valueX = opt[i - 1];
            opt[i] = max(valueY, valueX);
        }
        return opt[arr.length -1];
    }


    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 9, 1};
        final int recursion = dp_opt(arr);
        System.out.printf("MaxValue: %d", recursion);
    }
}
