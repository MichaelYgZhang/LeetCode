package com.leetcode;

import com.leetcode.common.TreeNode;

/**
 * 以根节点作为中轴线，左右两边节点交换
 * Input:
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * OutPut:
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {
    public TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        TreeNode tempLeft = root.left;
        root.left = invertBinaryTree(root.right);
        root.right = invertBinaryTree(tempLeft);
        return root;
    }
}
