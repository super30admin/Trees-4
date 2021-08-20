// TC: O(n)
// SC: O(n)

class Solution {
    int res, count;
    public int kthSmallest(TreeNode root, int k) {
        res = -1;
        count = 0;
        inorder(root, k);
        return res;
    }
    private void inorder(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        inorder(root.left, k);
        count++;
        if(count == k) {
            res = root.val;
            return;
        }
        if(res == -1) {
            inorder(root.right, k);
        }

    }
}