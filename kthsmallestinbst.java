//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
// Time Complexity :O(n)  
// Space Complexity :O(h) //stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
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
    private int cnt;
    private int result;
    public int kthSmallest(TreeNode root, int k) {
        cnt=k;
        helper(root);
        return result;
        
    }
    private void helper(TreeNode root)
    {
        //base
        if(root==null)
            return;
        //logic
        helper(root.left);
        cnt--; //least element is reached reduce the count
        if(cnt==0)
        {
            result=root.val;
            return;//this suspends the furthur recursion
        }
        helper(root.right);
    }
}