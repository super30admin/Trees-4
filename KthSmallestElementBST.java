class Solution {
    int counter;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        result = -1;
        helper(root, k);
        return result;
    }

    private void helper (TreeNode root, int k) {
        if (root == null) return;

        if (result == -1) {
            helper(root.left, k);
        }

        counter++;
        if (counter == k) {
            result = root.val;
        }
        if (result == -1) {
            helper(root.right, k);
        }


    }
}