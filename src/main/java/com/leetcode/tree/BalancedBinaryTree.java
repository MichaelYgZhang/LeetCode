package com.leetcode.tree;

public class BalancedBinaryTree {
    /**
     * 判断是否为平衡二叉树，叶子深度不大于1
     * @param root
     * @return
     */
//    int depth (TreeNode *root) {
//        if (root == NULL) return 0;
//        return max (depth(root -> left), depth (root -> right)) + 1;
//    }
//
//    bool isBalanced (TreeNode *root) {
//        if (root == NULL) return true;
//
//        int left=depth(root->left);
//        int right=depth(root->right);
//
//        return abs(left - right) <= 1 && isBalanced(root->left) && isBalanced(root->right);
//    }
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        int diff = Math.abs(left - right);
        if (diff > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int l = depth(root.left);
            int r = depth(root.right);
            if (l > r) {
                return l + 1;
            } else {
                return r + 1;
            }
        }
//        return Math.max(depth(root.left), depth(root.right)) + 1;

    }


    /**
     *          5
     *      * / \
     *      * 4   8
     *      * /   / \
     *      * 11  13  4
     *      * /  \    / \
     *      * 7    2  5   1
     *       9
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.left.left = new TreeNode(9);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(isBalanced(root));
    }
}

class Solution {
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return res;

    }
    private int maxDepth(TreeNode p) {
        if (p == null) {
            return 0;
        }
        int l = maxDepth(p.left);
        int r = maxDepth(p.right);
        if (Math.abs(l - r) > 1) {
            res = false;
        }
        return Math.max(l, r) + 1;
    }
}