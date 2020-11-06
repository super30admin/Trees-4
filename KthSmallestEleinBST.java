// Time Complexity : O(k)- as we traverse till we reach the Kth smallest element
// Space Complexity : O(N) - Internal stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
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
    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
       count = k;
       element(root);
       return result;
    }
    public void element(TreeNode root){
        if(root.left != null){
            element(root.left);
        }
        count--;
        if(count == 0){
            result = root.val;
            return;
        }
        if(root.right != null){
            element(root.right);
        }
    }
}

// Your code here along with comments explaining your approach
