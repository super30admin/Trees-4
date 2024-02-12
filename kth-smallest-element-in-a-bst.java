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
 //TC: O(N)
 //SC: O(1)
class Solution {
    TreeNode result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return result.val;
    }

    private void helper(TreeNode root, int k){
        if(root == null) return;
        helper(root.left,k);
        count++;
        if(k == count) result = root;
        if(result == null) helper(root.right,k);
    }
}
