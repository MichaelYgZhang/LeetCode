package com.leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断两个TreeNode的叶子节点是否相同
 * 比如:
 *          4           4
 *       7            1
 *     3   2        3   2
 * 输出: true
 * 思路: 递归遍历把所有叶子节点数据放到一个List集合中，然后比较是否相同
 */
public class LeafSimilarTrees {
    public boolean leafSimilarTrees(TreeNode<Integer> treeNode1, TreeNode<Integer> treeNode2){
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        List l1 = new ArrayList();
        List l2 = new ArrayList();
        DFS(treeNode1, l1);
        DFS(treeNode2, l2);
        return l1.equals(l2);
    }
    private void DFS(TreeNode<Integer> rootNode, List leafValues) {
        if (rootNode == null) {
            return;
        }
        if (rootNode.left == null && rootNode.right == null) {
            leafValues.add(rootNode.val);
            return;
        }
        DFS(rootNode.left, leafValues);
        DFS(rootNode.right, leafValues);
    }
}
