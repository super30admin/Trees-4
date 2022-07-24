// TC: O(N)
// SC: O(1)
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
        return helper(root, p, q);
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
       if(root == null || root.val == p.val || root.val == q.val)  return root;
        
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q); 
        
        if(left == null && right == null)   return null;   
        else if(left != null && right == null)  return left;  
        else if(right != null && left == null)  return right; 
        
        return root;
    }
}
