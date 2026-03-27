// Time Complexity : O(n)
// Space Complexity : O(h), h = height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to do an inorder traversal by visiting root's left, root and root's right and increment the count.
At any time if count reaches k value, we found the kth smallest element.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result;
    }

    private void helper(TreeNode root, int k) {
        if(root == null)
            return;
        if(result == 0)
            helper(root.left, k);
        count++;
        if(count == k) {
            result = root.val;
        }
        if(result == 0)
            helper(root.right, k);
    }
}