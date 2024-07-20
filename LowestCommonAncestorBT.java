/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/***
 TC - O(n)
 SC - O(h)
 */
class LowestCommonAncestorBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftSubtree =  lowestCommonAncestor(root.left, p, q);
        TreeNode rightSubtree = lowestCommonAncestor(root.right, p, q);

        if(leftSubtree != null && rightSubtree != null) {
            return root;
        }

        return leftSubtree != null ? leftSubtree : rightSubtree;

    }
}