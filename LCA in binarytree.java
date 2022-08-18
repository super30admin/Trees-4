// Time Complexity : o(n) 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return lca(root,p,q);
    }
    private TreeNode lca(TreeNode root,TreeNode p,TreeNode q){
        if(root==null || root==p || root==q) return root;
        
        TreeNode left= lca(root.left,p,q);
        TreeNode right= lca(root.right,p,q);
        
        if(left!=null && right==null) return left;
        if(right!=null && left==null) return right;
        if(left!=null && right!=null) return root;
        
        return null;
    }
}