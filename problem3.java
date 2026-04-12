
    /**
    Time Complexity : O(N)
    Explanation:
    We traverse the tree once and visit each node at most one time.

    Space Complexity : O(H)
    Explanation:
    Recursion stack depends on height of the tree.
    Worst case (skewed tree) → O(N), balanced → O(log N).

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially found it tricky to combine results from left and right subtree.
    The key idea was:
        - If both left and right return non-null → current node is LCA
        - If only one side returns non-null → propagate that upward
    Also needed to handle base cases when root equals p or q.
    */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {

        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        // If both sides found → this is LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return the non-null side
        return (left != null) ? left : right;
    }
}