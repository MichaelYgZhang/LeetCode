package com.leetcode.stack;

import java.util.Stack;

/**
 * 判断字符串是否有效
 * {}()[]
 *
 */
public class ValidParentheses {
    /**
     * 1 解法,时间复杂度过高
     */
    public static boolean isValidParentheses(String s) {
        int lenght;
        do {
            lenght = s.length();
            s = s.replace("()", "").replace("[]", "").replace("{}","");
        } while (lenght != s.length());
        return s.length() == 0;
    }

    /**
     * 2. stack 判断
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        final char[] chars = s.toCharArray();
        for (char c : chars) {
            if ('(' == c) {
                stack.push(')');
            } else if ('[' == c) {
                stack.push(']');
            } else if ('{' == c) {
                stack.push('}');
            } else if (stack.empty() || stack.pop() != c) {//如果判断不是配对说明校验失败
                return false;
            }
        }
        return stack.isEmpty();
    }
}
