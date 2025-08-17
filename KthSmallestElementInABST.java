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
    int answer;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        answer = -1;
        inorder(root, k);
        return answer;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null || answer != -1) {
            return;
        }

        inorder(root.left, k);

        count++;
        if (count == k) {
            answer = root.val;
            return;
        }

        inorder(root.right, k);
    }

}