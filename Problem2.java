// Time Complexity : O(log n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/**
 * Using the power of BST, we can check if
 * both p and q are on left side of the root if their values are smaller than root.
 * both their values are bigger than root, they are on right side of the root.
 * one is bigger and one is smaller than root, then we are standing at LCA.
 */
class BSTSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else
            return root;
    }
}
