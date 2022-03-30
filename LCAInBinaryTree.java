/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
 TC - O(N) where N is the number of nodes in a skewed tree.
 SC - O(H) where H is the height of the skewed tree.
 
 
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return lowestCommonAncestorHelper(root, p, q);
        
    }
    
    private TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q)
    {
        // base case
        if (root == null)
        {
            return null;
        }
        
        if (root == p || root == q)
        {
            return root;
        }
        
        
        // recur left
        TreeNode left_result = lowestCommonAncestorHelper(root.left, p, q);
        
        // recur right
        TreeNode right_result = lowestCommonAncestorHelper(root.right, p, q);
        
        if (left_result == null && right_result == null)
        {
            return null;
        }
        
        if (left_result != null && right_result != null)
        {
            return root;
        }
        
        return left_result != null ? left_result : right_result;
    }
}
