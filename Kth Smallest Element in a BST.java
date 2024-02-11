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
    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
         helper(root, k);
         return result.val;
    }

    private void helper(TreeNode root, int k)
    {
        if(root == null) return;

        helper(root.left, k);
        if(k == ++count)
        {
            result = root;
        }
        helper(root.right, k);
    }
}
