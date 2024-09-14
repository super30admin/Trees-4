//Time: O(h)
//Space: O(1)

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
        // Traverse the tree
        while (root != null) {
            // If both p and q are less than root, LCA must be in the left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If both p and q are greater than root, LCA must be in the right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // If root is between p and q, or root is one of p or q, we found the LCA
            else {
                return root;
            }
        }
        return null;  // In case there is no LCA (shouldn't happen in this problem)
    }
}
