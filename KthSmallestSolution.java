/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class KthSmallestSolution {
    private int cnt = 0;
    private int answer = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        cnt = k;
        answer = -1;
        inorder(root);
        return answer;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        cnt--;
        if (cnt == 0) {
            answer = root.val;
            return;
        }
        inorder(root.right);
    }
}