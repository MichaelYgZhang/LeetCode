package com.leetcode;

import com.leetcode.common.TreeNode;

/**
 * 给出两个TreeNode，判断是否相同
 * Input:
 *     6       6
 *   1    9  1   9
 * Output: true
 * Input:
 *      4      4
 *    2           2
 * Output: false
 * 思路: 挨个判断根节点，左子节点，右子节点
 */
public class SameTree {
    public static boolean isSameTree(TreeNode<Integer> q, TreeNode<Integer> p) {
        if (q == null && p == null) {
            return true;
        }
        if (q == null || p == null) {
            return false;
        }
        if (q.val == p.val) {
            return isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
        }
        return false;
    }
}
