// Time Complexity : O(n) because we may visit every node once
// Space Complexity : O(h) for recursion stack where h is tree height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use DFS recursion to search for nodes p and q in the left and right subtrees.
// If both left and right calls return non-null, the current node is the Lowest Common Ancestor.
// Otherwise, we return the non-null subtree result upward.

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // base case
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // nodes found on both sides
        if(left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}