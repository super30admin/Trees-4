// Time O(h) Space O(h)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution { TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        
     return   helper(root, p, q);
        //return res;
            
    }
    private TreeNode helper(TreeNode root, TreeNode p , TreeNode q)
    {
        if(root==null)
            return root;
        if(p.val>root.val && q.val>root.val)
           return helper(root.right, p, q);
       else if(p.val<root.val && q.val<root.val)
           return helper(root.left, p, q);
       else 
           return root;
        
    }
}