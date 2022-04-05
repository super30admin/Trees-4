// Time Complexity : O(n), with n nodes
// Space Complexity : O(n) for recursion stack
// Did this code successfully run on Leetcode : yes
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

class BSTSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val){ // right subtree
            return lowestCommonAncestor(root.right, p, q);
        }
        
        else if (p.val < root.val && q.val < root.val){ // left subtree
            return lowestCommonAncestor(root.left, p, q);
        }
        
        else { // neither: one is left subtree and other is right subtree
            return root; 
        }
        
    }
}