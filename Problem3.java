//236  Lowest Common Ancestor of a Binary Tree
// Time - O(h)
// space - O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        
       TreeNode left =  lowestCommonAncestor(root.left, p, q);
       TreeNode right = lowestCommonAncestor(root.right, p, q);
        
       if(left != null && right != null){
           return root;
       }
        if(right == null){
            return left;
        }
        
        if(left == null){
            return right;
        }
        
        return null;
    }    
}