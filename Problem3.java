//TC : O(n)
//SC : O(n) , since recursion stack

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
       return dfs(root,p,q);
    }
    
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        
        if(root == null) return null; // if we encounter root as null, return null becoz, we didn't find lca
        if( root == p || root == q) return root;  // we found one of p or q ,lca return root.
        
        TreeNode left = dfs(root.left, p,q);
        TreeNode right = dfs(root.right,p,q);
        
        if(left!=null && right!=null) return root;
        return (left!=null) ? left : right;
        
    }
}
