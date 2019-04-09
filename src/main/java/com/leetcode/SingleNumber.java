package com.leetcode;

import java.util.Arrays;

public class SingleNumber {
    /**
     * 一个数组总，只有一个数字出现一次，其它都是2次，找出这个出现1次的数字
     * [1,2,3,1,2] --> 3
     * 思路: 0 ^ N = N; N ^ N = 0;
     */
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) ans ^= num;
        return ans;
    }

    /**
     * 一个数组，有两个数字出现1次，其它都是2次，找出这2个出现一次的数字
     * 比如 [1, 2, 3, 4, 1, 2] --> [3, 4]
     * 思路: 在上一题的基础上, 找出3,4的不同点，把所有的数据分成两份
     */
    public static int[] singleNumberII(int[] nums) {
        int diff = 0;
        for (int num : nums) diff ^= num;
        diff = diff & -diff;//找到不同点
        int[] ret = new int[2];
        for (int num : nums){
            if ((num & diff) == 0) ret[0] ^= num;
            else ret[1] ^= num;
        }

        return ret;
    }
    public static void main(String[] args) {
        int[] arry = {1, 2, 3, 4, 1, 2};
        System.out.printf(Arrays.toString(singleNumberII(arry)));
    }
}
