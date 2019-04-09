package com.leetcode;

/**
 * 给两个二进制字符串比如 a = "11", b = "1" 输出 "100"
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        int i = aArray.length - 1;
        int j = bArray.length - 1;
        int aByte, bByte, carry = 0, result;
        StringBuilder sb = new StringBuilder();
        while (i > -1 || j > -1 || carry == 1) {
            aByte = (i > -1) ? Character.getNumericValue(aArray[i--]) : 0;
            bByte = (j > -1) ? Character.getNumericValue(bArray[j--]) : 0;
            result = aByte ^ bByte ^ carry;
            carry = ((aByte + bByte + carry) >= 2) ? 1 : 0;
            sb.append(result);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println( addBinary("110", "1"));
    }
}
