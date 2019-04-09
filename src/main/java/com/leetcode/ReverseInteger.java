package com.leetcode;

/**
 * 反转整数:
 * in: 123 out: 321 ; in: -123 out: -321; in: 120 out:21
 * 思路: 整除10，然后再乘以10   注意判断 120 这种情况
 */
public class ReverseInteger {
    public static int reverse(int num) {
        int rest = 0;
        while (num != 0) {
            int last = num % 10;
            int temp = rest * 10 + last;
            if ((temp - last)/10 != rest) {
                return 0;
            }
            num = num / 10;
            rest = temp;
        }
        return rest;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
