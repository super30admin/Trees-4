public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class kthSmallestBST {
    int count;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        count = k;
        res = -1;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null || res != -1) // to avoid unnecessary recursive calls after res is set to expected ans
        {
            return;
        }
        inorder(root.left);
        count--;
        if (count == 0)
            res = root.val;
        inorder(root.right);
    }

    public static void main(String[] args) {
        kthSmallestBST b = new kthSmallestBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(3);
        int k = 1;
        System.out.println(b.kthSmallest(root, k));
    }
}
