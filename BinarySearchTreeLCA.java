// Time Complexity : O(n)
// Space Complexity : O(h) [Height of the BST]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

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
        // return helperDfs(root, p, q);
        // return helperDfsIterative(root, p, q);
        return helperDfsBottomUp(root, p, q);
    }

      private TreeNode helperDfsBottomUp(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftLca = helperDfsBottomUp(root.left, p, q);
        TreeNode rightLca = helperDfsBottomUp(root.right, p, q);

        if(leftLca == null && rightLca == null) {
            return null;
        } else if(leftLca != null && rightLca == null) {
            return leftLca;
        } else if(leftLca == null && rightLca != null) {
            return rightLca;
        } else {
            return root;
        }
    }

    private TreeNode helperDfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }

        if(root.val > p.val && root.val > q.val) {
            return helperDfs(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val) {
            return helperDfs(root.right, p, q);
        } else {
            return root;
        }
    }
    private TreeNode helperDfsIterative(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }

        while(true) {
            if(root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if(root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
}