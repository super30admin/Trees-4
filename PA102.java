//Leetcode 236. Lowest Common Ancestor of a Binary Tree
//Time complexity: O(n), n is total no of nodes in the tree
//Space COmplexity: O(n), stack space
class Solution {
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        return helper( root, p, q);
        
    }
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        
        if(root==p || root==q) return root;
        TreeNode lt = helper( root.left, p, q);
        TreeNode rt= helper( root.right, p, q);
        if(lt!=null && rt!=null ){
            return root;
        }
        else if(lt!=null){return lt;}
        else{
            return rt;
        }
    }
}