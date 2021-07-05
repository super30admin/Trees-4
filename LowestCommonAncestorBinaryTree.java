//Problem:103-Lowest Common Ancestor of a Binary Tree
//TC:O(N)
//SC:O(H), considering recursive stack

class Solution103 {

     class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //TC:O(N),SC:O(H), considering recursive stack
        if(root==null || p==null || q==null) return null;
        
        return helper(root,p,q);
        
    }
    
    private TreeNode helper(TreeNode root,TreeNode p, TreeNode q){
        
        if(root==null) return null;
        
        if(root==p || root==q){
            return root;
        }
        
        TreeNode left  = helper(root.left,p,q);
        TreeNode right = helper(root.right,p,q);
        
        if(left==null) return right;
        if(right==null) return left;
        
        return root;
    }
    
}