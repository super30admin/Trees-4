/*
Problem: Lowest Common Ancestor of a Binary Tree (LeetCode 236)
Approach: Single-pass recursive DFS. If current node is null or equals p/q return it. Recurse left and right; if both sides return non-null, current node is LCA; otherwise propagate non-null child.
Time Complexity: O(n)
Space Complexity: O(n) recursion stack.
LeetCode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
*/

public class LowestCommonAncestorInBinaryTree2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        else if (left != null && right == null)
            return left;
        else if (left == null && right != null)
            return right;
        else
            return null;
    }
}
