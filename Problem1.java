// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//Time complexity : O(N)
//Space complexity : O(H)
class Solution {
    int l = 0;
    int val = -1;

    public int kthSmallest(TreeNode root, int k) {
        l = k;
        inorder(root);
        return val;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (--l == 0) {
            val = root.val;
        }
        inorder(root.right);
    }
}