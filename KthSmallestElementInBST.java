public class KthSmallestElementInBST {
    TreeNode res;
    int count = 0;
    // TC: O(N) where N is number of nodes
    // SC: O(H) where H is height of tree
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res.val;
    }
    private void helper(TreeNode root, int k) {
        if (root == null) return;
        helper(root.left, k);
        count++;
        if (count == k) {
            res = root;
        }
        helper(root.right, k);
    }
}
