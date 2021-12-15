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
    int kOut;
    public int kthSmallest(TreeNode root, int k) {
        kOut = k;
        return helper(root);
    }
    public int helper(TreeNode node){
        if(node == null)
            return -1;

        int temp = helper(node.left);
        if(temp!=-1)
            return temp;

        if(kOut-- == 1)
            return node.val;

        return helper(node.right);
    }
}