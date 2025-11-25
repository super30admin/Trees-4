/*
Problem: Lowest Common Ancestor of a Binary Tree (LeetCode 236)
Approach: DFS to record the path from root to p and root to q. Then compare the two paths to find the last common node.
Time Complexity: O(n) to traverse the tree.
Space Complexity: O(n) for storing paths and recursion stack.
LeetCode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
*/

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorInBinaryTree {
    private List<TreeNode> pPath;
    private List<TreeNode> qPath;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q, new ArrayList<>());
        for (int i = 0; i < pPath.size(); i++) {
            if (pPath.get(i).val != qPath.get(i).val) {
                return pPath.get(i - 1);
            }
        }
        return root;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        //base
        if (root == null) return;
        if(pPath!= null && qPath!= null) return;

        //logic
        //action
        path.add(root);
        if (root.val == p.val) {
            pPath = new ArrayList<>(path);
            pPath.add(root);
        }

        if (root.val == q.val) {
            qPath = new ArrayList<>(path);
            qPath.add(root);
        }
        //recursion
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        //backtrack - fixed to use List API
        path.remove(path.size() - 1);
    }
}
