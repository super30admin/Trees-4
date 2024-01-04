/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/*
 * Approach-1
 * build a path , and add it to pathp, pathq
 * at last traverse a for loop, and return i-1 hen found uncommon node
 * hande edge case, out of bound, by adding the extra node twice at the end
 */

/** FOLLOWING CODE WORKS FOR BST AND BT BOTH */
class Solution {

    // USING PROPERTY OF BST left < root, and right side > root
    // satck space: O(h) ; time :O(log n) //we will just search for half side of the
    // tree.
    class Solution {
        TreeNode result;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null)
                return null;

            result = null;

            helperBST(root, p, q);

            return result;
        }

        private void helperBST(TreeNode root, TreeNode p, TreeNode q) {
            // base case
            if (root == null)
                return;

            if (p.val < root.val && q.val < root.val)
                helperBST(root.left, p, q);
            else if (p.val > root.val && q.val > root.val)
                helperBST(root.right, p, q);
            else if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
                result = root;
                return;
            }
        }
    }

    // iterative approach

    /*
     * Approach-Optimized approach
     * Iterative
     * SC: O(1)
     * tc:O(h)
     */
class Solution {
    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {
            if (p.val < root.val && q.val < root.val)
                root = root.left;

            else if (p.val > root.val && q.val > root.val)
                root = root.right;

            else if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
                result = root;
                break;
            }
        }
        return result;
    }

}