//Time = O(n), n is number of nodes.
//Space = O(n)

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
        if (root == null || root == p || root == q) {
            return root; // base case: root is null or one of the nodes is the root itself
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root; // both nodes are on different sides of the root, so root is the LCA
        } else if (left != null) {
            return left; // both nodes are on the left side of the root, so LCA is on the left side
        } else {
            return right; // both nodes are on the right side of the root, so LCA is on the right side
        }
    }
}
