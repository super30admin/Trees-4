//230. Kth Smallest Element in a BST: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// Time Complexity : O(N)
// Space Complexity : O(Height) [bcz, we are using stack. If we use array, it will be O(N)]
// Did this code successfully run on Leetcode :yes
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
    int result;
    int count;
    
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        
        inorder(root, k);
        return result;
    }
    
    private void inorder(TreeNode root, int k){
        //base
        if(root == null) return;
        //logic
        inorder(root.left, k);
        
        count++;
        if(count == k){
            result = root.val;
            return;
        }
        
        inorder(root.right, k);
    }
}