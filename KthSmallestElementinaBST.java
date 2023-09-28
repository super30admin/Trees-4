//tc =O(n)
// sc = O(h)

public class KthSmallestElementinaBST {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;

    }

    private void inorder(TreeNode root) {
        // base
        if (root == null)
            return;
        // logic
        inorder(root.left);
        count--;
        if (count == 0) {
            result = root.val;
        }
        inorder(root.right);

    }
}