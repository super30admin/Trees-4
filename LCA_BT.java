// Time Complexity :O(n) // n-number of nodes
// Space Complexity :O(h) - Stack space // h- maximum height of the tree 
// Did this code successfully run on Leetcode :yes 
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //base
        if(root==null || p.val==root.val || q.val==root.val) return  root;
        
        //logic
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        
        if(left!=null && right!=null) return root;
        else if(left!=null) return left;
        else if(right!=null) return right;
        else return null;
                
    }
}