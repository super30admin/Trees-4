// Time Complexity : O(n) where n is number of digits in number
// Space Complexity : O(h);h -> height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : In this case, we need to explore both left as well as right sides.
// The main intuition is similar as BST approach. If p and q are found to be on opposite sides of each other, then we know surely that root is the common ancestor.

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
        if(root == null || p == root || q == root) return root;
        TreeNode left =  lowestCommonAncestor(root.left, p, q);
        TreeNode right =  lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) // p and q lie on the opposite sides
            return root;
        return left != null ? left : right;
    }
}

