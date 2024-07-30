// Time Complexity :O(n)
// Space Complexity :O(h)
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
class KthSmallest {
    int count;
    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
        this.count = 0;
        helper(root, k);
        return result.val;
    }
    private void helper(TreeNode root, int k) {
        //base case
        if(root == null) return;

        //logic
        if(result == null)
            helper(root.left,k);
        count++;
        if(count == k) result = root;
        if(result == null)
            helper(root.right,k);
    }
}