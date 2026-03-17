/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/**
 * Recursively finds LCA by exploring left and right subtrees.
 * If both sides return non-null, current node is the split point → LCA.
 * Time: O(n) visiting each node once, Space: O(h) recursion stack (h = tree height).
 */
class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        // If current node matches either p or q, return it upward as a signal
        // (acts as a base case and propagates match up the recursion stack)
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Key invariant:
        // If p and q are found in different subtrees, this node is their LCA
        if (left != null && right != null) { 
            return root;
        }

        // Otherwise, propagate the non-null result upward (either found node or LCA below)
        return (left != null) ? left : right;
    }
}