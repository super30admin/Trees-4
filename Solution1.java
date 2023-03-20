// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I perform inorder traversal and keep a count of all elements. As soon as I reach
 * kth element in the inorder traversal, I return it.
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
    int sol = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return sol;
    }

    public void inorder(TreeNode root, int k)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left,k);
        count++;
        if(count==k)
        {
            sol=root.val;
            return;
        }
        inorder(root.right,k);
    }
}