// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We can do inorder traversal and keep track of the number of elements processed
//We we encounter the kth element it will be our answer
//Since the inorder traveral of BST gives elements in sorted order

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
    int ans = -1;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        compute(root);
        return ans;
    }
    private void compute(TreeNode root){
        if(root == null)
            return;
        compute(root.left);
        k--;
        if(k == 0){
            ans = root.val;
            return;
        }
        compute(root.right);   
    }
}