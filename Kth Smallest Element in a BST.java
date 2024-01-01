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

//  Time Complexity: O(k)
//  Space Complexity: O(h)
class Solution {

    int count;
    TreeNode result;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        this.result = null;

        helper(root);
        return result.val;
    }

    private void helper(TreeNode root){
        if(root == null) return;

        if(result != null) return;

        helper(root.left);
        count--;
        if(count == 0) result = root;
        helper(root.right);
    }
}