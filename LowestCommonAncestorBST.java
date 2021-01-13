// Time Complexity : O(h)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


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


// We start traversal from root. If both p and q are in left subtree, we switch root to root.left and continue search
// If both p and q are in right subtree, root is updated to root.right and continue
// If above conditions fail, return root
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return root;
        
        while(root != null) {
            
            if(p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            else if(p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            else {
                return root;
            }
        }
        return null;
    }
}