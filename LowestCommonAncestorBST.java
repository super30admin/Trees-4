// Time Complexity : O(logn) where n is number of nodes in tree
// Space Complexity : O(h);h -> height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : 
// case 1: Both p & q are on left of root. In this case we are sure that the result lies on the left side. Therefore, we'll recursively explore the nodes on the left.
// case 2: Both p & q are on right of root. In this case we are sure that the result lies on the right side. Therefore, we'll recursively explore the nodes on the right.
// In any other scenario i.e. if p & q are on opposite sides or if p or q one of them is root itself, we'll be returning the root node.

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
        if(p.val < root.val && q.val < root.val) {// search left subtree recursively
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > root.val && q.val > root.val) {// search right subtree recursively
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}

