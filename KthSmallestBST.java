public class KthSmallestBST {
    //TIme Complexity: O(N) - > N is the number of nodes
    //Space Complexity: O(1)
    int val = -1;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrderTraverse(root);
        return val;

    }
    private void inOrderTraverse(TreeNode root) {
        if (root == null || val != -1) return;

        if (val == -1) {
            inOrderTraverse(root.left);
        }

        k = k - 1;
        if (k == 0) {
            val = root.val;
            return;
        }
        if (val == -1) {
            inOrderTraverse(root.right);
        }
    }
}
