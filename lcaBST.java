// TC - O(h) - height of tree
// SC - O(h) - recursive stack

// Approach
// We recursively traverse the tree until one of the nodes is on the right of 
// the root, and the other one is on the left side of the root.

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
        if(root == null) {
            return root;
        }

        while(true) {
            if(root.val > p.val && root.val > q.val) {
                // current element is greater than both, move left to find a lower ancestor
                root = root.left;
            } else if(root.val < p.val && root.val < q.val) {
                // current element is lower than both, move right to find a lower ancestor
                root = root.right;
            } else {
                // otherwise you're at the lowest common ancestor
                return root;
            }
        }
    }
}
