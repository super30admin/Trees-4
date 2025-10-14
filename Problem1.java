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
 // 230. Kth Smallest Element in a BST
/*
Ran on leetcode: Yes
Traverse inorder to get elements in ascending order and then keep track of elements visited in inorder and stop at kth element
TC: O(n)
SC: O(1)
*/

class Solution {
    
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        helper(root, k);
        return result;
    }

    // traverse inorder cauz we have an ascending order in BST
    public void helper(TreeNode root, int k){
        if(root == null){
            return;
        }

        // traverse left is result is not found
        if(result == -1){
            helper(root.left, k);
        }

        // count till we have k elements
        count++;

        if(count == k){
            result = root.val;
        }
       
        // traverse right if the result is not found
        if(result == -1){
            helper(root.right, k);
        }
    }
}