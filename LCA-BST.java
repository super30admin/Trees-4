/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LCA-BST {
    
    // Time Complexity: O(h)    (where h -> height of the tree)
    // Space Complexity: O(h)   
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Edge Case Checking
        if(root == null)
            return null;
        // If our root is any of the element - then that is one ancestor (which can be lowest)
        if(root.val == p.val || root.val == q.val)
            return root;
        
        // If both the values (p and q) are less than the root.val --> go to the left side of the tree
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        // If both the values (p and q) are greater than the root.val --> go to the right side of the tree
        else if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        // Othewise, we are at the split point - which is the LCA
        else
            return root;
    }
}