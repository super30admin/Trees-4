// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
inorder traversal
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
    int result;
    boolean flag;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        count--;
        if(count==0){
            result=root.val;
            flag=true;
        }
        if(!flag){
            inorder(root.right);
        }
    }
}

