// Time Complexity : O(n) - n is the number of nodes available in tree
// Space Complexity: O(n) - recursive stack space to maintain all the nodes 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Approach
// Bottom Up approach
// IF both right and left nodes returns any value then the root is the LowestCommonAncestor
// 
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
     
        return lca(root,p,q);
    }
    private TreeNode lca(TreeNode root, TreeNode p , TreeNode q){
        
        //base
        if(root == null)
            return root;
        
        if(root.val == p.val || root.val ==q.val)
            return root;
        
        //logic
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        
         if(left != null && right != null){
            return root;
        }
        if(left != null)
            return left;
        if(right != null)
            return right;
        
       
     return null;   
    }
}
