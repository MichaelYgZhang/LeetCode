package com.sort;

import java.util.Arrays;

/**
 * @author ：michael
 * @date ：2021/9/5 10:34 PM
 * @description：迭代练习
 * @modified By：michael
 * @version: $
 */
public class iterator {

    public static void main(String[] args) {
        int[] nums = {11, 2, 4, 5, 7};
        System.out.println("sum=" + sum(nums));

        System.out.println("count=" + count(nums));

        System.out.println("findMaxNum=" + findMaxNum(nums));
    }

    private static int sum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        final int[] copy = Arrays.copyOfRange(nums, 1, nums.length);

        return nums[0] + sum(copy);
    }

    private static int count(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        final int[] copy = Arrays.copyOfRange(nums, 1, nums.length);


        return 1 + count(copy);
    }


    private static int findMaxNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        final int[] copy = Arrays.copyOfRange(nums, 1, nums.length);
        return nums[0] > findMaxNum(copy) ? nums[0] : findMaxNum(copy);
    }

}
