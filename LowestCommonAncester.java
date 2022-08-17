/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity: O(h), as only one side of the tree is being traversed at the
// max
// Space Complexity: O(1)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        // Iterative Solution
        while (true) {
            if (root.val > p.val && root.val > q.val) { // if both p&q are less than root value, move left to find LCA
                                                        // of p&q
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) { // if both p&q are more than root value, move right to
                                                               // find LCA of p&q
                root = root.right;
            } else {
                return root; // if there is no definite direction, then p&q lie at either sides of the root,
                             // hence root=LCA
            }
        }

    }
}