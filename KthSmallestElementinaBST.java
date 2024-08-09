// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    int count;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {
        // base
        if (root == null)
            return;

        // logic
        inorder(root.left, k);
        count++;
        if (count == k)
            result = root.val;
        if (count < k)
            inorder(root.right, k);
    }
}