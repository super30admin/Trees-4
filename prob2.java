/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//TC:O(n)
//SC:o(maxdepth)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        
        if(root==null) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        
        if(root.val==p.val||root.val==q.val)
              return root;
        else if(left!=null && right!=null)
              return root;
        else if(left!=null && right==null)
               return left;
        else 
               return right;
        
        
        
        
        
        
        
        
        
    }
}