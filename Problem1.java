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
    int kGlobal = 0;
    int returnVal = -1;
    public int kthSmallest(TreeNode root, int k) {
        
        findkthSmallest(root, k);

        return returnVal;

    }

    private void findkthSmallest(TreeNode root, int k) {

        if (root == null || returnVal != -1) return;

        findkthSmallest(root.left, k);
        kGlobal++;
        if (k==kGlobal) {
            returnVal = root.val;
            return;
        }
        findkthSmallest(root.right, k);

    }
}
