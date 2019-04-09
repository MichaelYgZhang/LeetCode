package com.leetcode;

import com.leetcode.common.TreeNode;

/**
 * 判断是否为对称树
 *         1
 *    2         2
 *  4   3     3   4
 *  outPut: true
 *         1
 *      2      3
 *  outPut: false
 *  思路：递归从左子树和右子树开始的节点，分别比较值是否相等，然后递归比较，left.left VS right.right   && left.right VS right.left
 */
public class SymmetricTree {
    public boolean isSymmetricTree(TreeNode treeNode) {
        if (treeNode == null || (treeNode.left == null && treeNode.right == null)) {
            return true;
        }
        return isSymmetricTree(treeNode.left, treeNode.right);
    }

    private boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
    }
}
