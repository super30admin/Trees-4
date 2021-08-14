// Time Complexity : o(n)
// Space Complexity : 0(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       //base
        if(root==null||root==p||root==q)
            return root;
        
        //logic
        TreeNode left=lowestCommonAncestor( root.left,  p,  q);
        TreeNode right=lowestCommonAncestor( root.right,  p,  q);
        
        if(left!=null && right!=null)
            return root;
        
        else if(left!=null)
            return left;
        else if(right!=null)
            return right;
        else
            return null;
    }
}
