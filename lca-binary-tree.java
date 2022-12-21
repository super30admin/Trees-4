
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

//tc is O(h)
//sc is O(h)
class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();

        dfs(root, p, q, new ArrayList<>());

        for (int i = 0; i < pathP.size(); i++) {

            if (pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i - 1);
            }

        }

        return null; // it should ideally never reach here

    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {

        // base

        if (root == null)
            return;

        // logic

        path.add(root);
        if (root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }

        if (root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }

        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);

        // backtrack
        path.remove(path.size() - 1);

    }
}