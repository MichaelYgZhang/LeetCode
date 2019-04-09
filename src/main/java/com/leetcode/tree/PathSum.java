package com.leetcode.tree;


import java.util.ArrayList;
import java.util.List;

public class PathSum {
    /**
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int nextValue = sum - root.val;
        if (nextValue == 0 && root.left == null && root.right == null) {
            return true;
        }
        if (hasPathSum(root.left, nextValue)) {
            return true;
        }
        if (hasPathSum(root.right, nextValue)) {
            return true;
        }
        return false;
    }

    /**
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \    / \
     * 7    2  5   1
     * outPut:
     * [
     * [5,4,11,2],
     * [5,8,4,5]
     * ]
     */
    public static void pathSum(TreeNode root, int sum, List<Integer> sublist, List<List<Integer>> pathlist) {
        if (root == null) {
            return;
        }
        sublist.add(root.val);
        sum = sum - root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                pathlist.add(new ArrayList<Integer>(sublist));
            }
        } else {
            if (root.left != null) {
                pathSum(root.left, sum, sublist, pathlist);
            }
            if (root.right != null) {
                pathSum(root.right, sum, sublist, pathlist);
            }
        }
        //把不符合条件的去除
        sublist.remove(sublist.size() - 1);
    }

    public static List<List<Integer>> pathSumII(TreeNode root, int sum) {
        List<List<Integer>> pathlist = new ArrayList<List<Integer>>();
        List<Integer> sublist = new ArrayList<Integer>();
        pathSum(root, sum, sublist, pathlist);
        return pathlist;
    }

    /**
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     * Return 3. The paths that sum to 8 are:
     *
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3. -3 -> 11
     *
     */

    public int pathSumIII(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumIII_dfs(root, sum) + pathSumIII(root.left, sum) + pathSumIII(root.right, sum);
    }

    public int pathSumIII_dfs(TreeNode root, int sum) {
        int res = 0;
        if (root == null) {
            return res;
        }
        if (sum == root.val) {
            res++;
        }
        res += pathSumIII_dfs(root.left, sum - root.val);
        res += pathSumIII_dfs(root.right, sum - root.val);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
//        System.out.println(hasPathSum(root, 22));
//        root.right = null;
//        root.left = null;
//        root.val = 1;
        List<List<Integer>> lists = pathSumII(root, 22);
        System.out.println(lists.toString());
    }
}
