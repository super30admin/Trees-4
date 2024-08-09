
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Tc --> O(logn)
 * Sc --> O(h)
 */

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return Helper(root, p, q);
    }

    public TreeNode Helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {
            if (root.val > p.val && root.val > q.val) {
                return Helper(root.left, p, q);
            } else if (root.val < p.val && root.val < q.val) {
                return Helper(root.right, p, q);
            } else {
                return root;
            }
        }//if
        return null;
    }//method

}
