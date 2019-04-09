package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层级遍历树
 */
public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<Integer>();
            int qSize = queue.size();
            // qSize不能直接写到for i < queue.size() ; 变化的，下面加上了在去判断数据就不准确了
            for (int i = 0; i < qSize; i++) {
                TreeNode node = queue.poll();
                currLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(currLevel);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        final List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> l : lists) {
            System.out.println(l.toString());
        }
    }
}
