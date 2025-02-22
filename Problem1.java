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

/*
TC -> O(N)
SC -> O(H)
*/
class Solution5 {
    int count, ans;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        count = k;
        ans = -1;
        inOrder(root);
        return ans;
    }

    private void inOrder(TreeNode root) {
        // base
        if (root == null || ans != -1) {
            return;
        }
        // logic
        inOrder(root.left);
        count--;
        if (count == 0) {
            ans = root.val;
        }
        inOrder(root.right);

    }
}