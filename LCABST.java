/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //Time complexity : O(h), worst case O(n) -> skewed tree
 //Space complexity : O(h), worst case O(n) -> skewed tree

 /**
 * Uses BST property to traverse down: if both nodes are smaller go left, if both larger go right.
 * The first node where p and q split (or one equals root) is the LCA.
 * Time: O(h), Space: O(h) recursion stack (worst O(n) for skewed tree)
 */

class LCABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // If both p and q lie in left subtree, LCA must be in left
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);

        // If both p and q lie in right subtree, LCA must be in right
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);

        } else {
            // Split point: one node on each side OR one equals root → this is LCA
            return root;
        }
    }
}