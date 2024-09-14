//Time: O(n)
//Space: O(h) h is height of tree for recursive stack
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
        // Base case: if the root is null or equals to p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Recursively find LCA in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both left and right are non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise, return the non-null child
        return left != null ? left : right;
    }
}
