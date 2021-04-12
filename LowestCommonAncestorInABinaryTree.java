/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// TC - O(number of nodes in tree), SC - O(height of tree)
// LC - 236

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
		// base condition
        if(root == null){
            return root;
        }
        
		// if root val is p or q, we return root
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        
		// calling recursion function
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
		// Both sides of root returns some value, so root would be the LCA, if left != null, return left else return right
        if(left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else{
            return right;
        }
        
    }
}