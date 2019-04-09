package com.leetcode.DP;

/**
 * 爬楼梯问题，1步或2步，n层楼梯共有多少种方法？
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
           return climbStairs(n-1) + climbStairs(n-2);
        }
    }

    public static int dp_climbStairs(int n) {
        int[] result = new int[n];
        if (n <= 1) {
            return 1;
        }
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n-1];
    }

    public int dp_climbStairs2(int n) {
        // base cases
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for(int i=2; i<n; i++){
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }


    public static void main(String[] args) {
        System.out.printf("n: %d", dp_climbStairs(4));
    }
}
