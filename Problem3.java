// Time: O(n)
// Space: O(n)
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
        if(root == null) return root;

        return dfs(root,p,q) ;
        
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root == p || root == q){
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        
        return left == null ? right: left;
    }
}