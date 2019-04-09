package com.leetcode;

import com.leetcode.common.TreeNode;

/**
 * Input:
 * Tree1                Tree2
 *          1                 2
 *        3   2           1       3
 *      5                   4        7
 * Output:
 *        3
 *    4      5
 *  5   4      7
 *
 * 思路: 递归两个链表，如果不为null则val相加，tree1左子树 + tree2左子数
 */

public class MergeTwoBinaryTrees {
    public static TreeNode mergeTrees(TreeNode<Integer> t1, TreeNode<Integer> t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode t1 = builderTree1();
        TreeNode t2 = builderTree2();
        TreeNode result = mergeTrees(t1, t2);
        printTreeNode(result);
    }

    /**
     * root -> left -> right 根左右遍历
     * 输出: ->3->4->5->4->5->7
     */
    public static void printTreeNode(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print("->" + treeNode.val);
        printTreeNode(treeNode.left);
        printTreeNode(treeNode.right);
    }

    public static TreeNode<Integer> builderTree1(){
        TreeNode<Integer> v3 = new TreeNode(3);
        TreeNode<Integer> t1 = new TreeNode(1);
        t1.left = v3;
        t1.right = new TreeNode(2);
        v3.left = new TreeNode(5);
        return t1;
    }
    public static TreeNode<Integer> builderTree2(){
        TreeNode<Integer> v1 = new TreeNode(1);
        TreeNode<Integer> v2 = new TreeNode(2);
        TreeNode<Integer> v3 = new TreeNode(3);
        TreeNode<Integer> v4 = new TreeNode(4);
        TreeNode<Integer> v5 = new TreeNode(5);
        TreeNode<Integer> v7 = new TreeNode(7);
        TreeNode<Integer> t2 = v2;
        t2.left = v1;
        t2.right = v3;
        v1.right = v4;
        v3.right = v7;
        return t2;
    }
}
