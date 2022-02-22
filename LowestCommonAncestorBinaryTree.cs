/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

public class Solution {

    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return Helper(root, p, q);
    }
    
    private TreeNode Helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        
        //draw tree and visualize different usecases
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        
        TreeNode left = Helper(root.left, p, q);
        TreeNode right = Helper(root.right, p, q);
        
        if(left != null && right != null) {
            return root;
        } else if(left != null) {
            return left;
        } else if(right != null) {
            return right;
        }
        return null;
    }
    
}