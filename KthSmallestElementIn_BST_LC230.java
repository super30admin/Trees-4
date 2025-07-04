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
class KthSmallestElementIn_BST_LC230 {
    int count = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTrav(root, k);
        return result;
    }

    private void inOrderTrav(TreeNode root, int k) {
        if (root == null) return;

        inOrderTrav(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inOrderTrav(root.right, k);
    }
}