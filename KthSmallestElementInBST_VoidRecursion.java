/* Time Complexity: O(n)
 * Space Complexity: O(h)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
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
        count = k;
        inorder(root);
        return result;
    }
    public void inorder(TreeNode root){
        //base
        if(root == null) return;
        //logic
        inorder(root.left);
        count--;
        if(count == 0){
            result = root.val; 
            return;
        }
        inorder(root.right);
    }
}

/*
class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }
    public void inorder(TreeNode root){
        //base
        if(root == null) return;
        //logic
        inorder(root.left);
        count--;
        if(count == 0){
            result = root.val; 
            return;
        }
        inorder(root.right);
    }
}
*/