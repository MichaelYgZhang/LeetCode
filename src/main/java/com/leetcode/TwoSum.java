package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给一个整数数组，一个target，返回当前和为target的数组下标的数据....
 * in: nums = [2, 7, 11, 15] target = 9   out: [0, 1]   (2+7=9)
 * 思路: 1: 暴力发，直接遍历即可
 *      2: Map求解,时间复杂度o(n)
 * 拓展: 三个的怎么做？
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0, len = nums.length; i < len; i++){
            int temp = nums[i];
            if (map.containsKey(target - temp)) {
                return new int[] {map.get(target - temp), i};
            }
            map.put(temp, i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
