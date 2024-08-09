
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Tc --> O(n)
 * SC --> O(h)
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return Helper(root, p, q);

    }

    private TreeNode Helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node != null) {
            if (node == p || node == q) {
                return node;
            }//if
            TreeNode left = Helper(node.left, p, q);
            TreeNode right = Helper(node.right, p, q);
            if (left != null && right != null) {
                return node;
            }
            if (left != null) {
                return left;
            } else if (right != null) {
                return right;
            }
        }
        return null;
    }
}
