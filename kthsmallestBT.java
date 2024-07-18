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
class Solution {
    int count, ans;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        count = k;
        ans = -1;
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null || answer != -1) { // limits further recursive calls
            return;
        }
        inorder(root.left); // move left
        count--;
        if(count == 0){
            ans = root.val;
            return;
        }
        inorder(root.right); // move right
    }
}