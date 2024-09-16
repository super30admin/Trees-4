// Problem 235. Lowest Common Ancestor of a Binary Search Tree
// Time Complexity : O(h)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
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
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            else {
                return root;
            }
        }
        return null;
    }
}
