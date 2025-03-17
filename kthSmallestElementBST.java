// Problem1 Kth Smallest Element in a BST (https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

// Time Complexity : O(n) 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take count result and flag as global variables and intialize count with k. In helper do inorder travesal and after completing left
 * recursion reduce count by 1 and check if count is 0, if yes make result as root.val and flag as true if not make right recursive call
 * if flas is not true. Finally return result.
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
    boolean flag;
    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        this.result = result;
        this.flag = false;
        helper(root);
        return result;
    }
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        count --;
        if(count == 0){
            result = root.val;
            flag = true;
        }
        if(!flag) helper(root.right);
    }
}