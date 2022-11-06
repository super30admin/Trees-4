// Time Complexity : O(k)
// Space Complexity : O( h+ K) bu its oprimized to O(k)
// Did this code successfully run on Leetcode : Yes
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
    int result=-1;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;

        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode node, int k) {

        // base case
        if (node == null) return;

        // recursion
        if (result == -1) dfs(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        if (result == -1) dfs(node.right, k);
    }
}
