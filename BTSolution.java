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

class BTSolution {
    public TreeNode recurse(TreeNode root, TreeNode p, TreeNode q) {      
        if (root == null || root == p || root == q){ // if root is null, will return null
            return root;
        }
        
        TreeNode left = recurse(root.left, p, q);

        TreeNode right = recurse(root.right, p, q);
        
        if (left != null && right != null){ //p , q exist on different subtree
            return root;
        }
        
        return left != null ? left : right; // p, q exist on same subtree
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recurse(root, p , q);
    }
    
    
}