package bst;

// Time Complexity : O(n) n is the number of nodes.
// Space Complexity : O(h) h is the height of the tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Recursive {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        // go left
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // go right
        else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}