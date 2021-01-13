// Time Complexity : O(n) 
// Space Complexity :O(h) h- height of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach: Maintain a variable count and do a inorder traversal and increase the count
// if the count equals k, we store the value of that in result and return.
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
    int cnt,result;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return result;
    }
    public void dfs(TreeNode root, int k){
         if(k==cnt){
            return;
        }
        if(root==null)
            return;
        dfs(root.left,k);
        cnt++;
        if(k==cnt){
            result=root.val;
            return;
        }
        dfs(root.right,k);
         
        
    }
}