// Time Complexity : O(k) where k is the kth element to be found
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/**
 * Using inorder traversal to first go to the minimum number on BST. Then reducing the count by 1 every time one node is returned from recursive stack. When count hits 0, that is our kth element.
 */
class Solution {
    int res = -1;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        helper(root);
        return res;
    }

    private void helper(TreeNode node) {
        if (node == null || res != -1)
            return;

        helper(node.left);

        count--;
        if (count == 0)
            res = node.val;

        helper(node.right);
    }
}