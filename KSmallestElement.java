// Time Complexity : 0(h+k)
// Space Complexity : 0(h) for recurssion stack where h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
class KSmallestElement {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k){
        if(root == null){
            return;
        }
        if(result == 0){
            inorder(root.left, k);
        }
        count++;
        if(count == k){
            result = root.val;
            return;
        }
        if(result == 0){
            inorder(root.right, k);
        }
    }
}