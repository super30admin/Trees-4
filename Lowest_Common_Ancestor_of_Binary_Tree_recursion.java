/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// TC : O(n)
// SC : O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return root;
        
        return helper(root, p, q);
        
    }
    
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root.val == p.val || root.val == q. val)
            return root;
        
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if(left == null && right == null) return null;
        if(left != null && right == null) return left;
        if(right != null && left == null) return right;
        return root;

    }
}
