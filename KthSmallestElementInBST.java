// Time complexity : O(n)
// Space complexity : O(h)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class KthSmallestElementInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        int k = 4;
        int result = kthSmallest(root, k);
        System.out.println(result);
    }

    static int count;
    static TreeNode result;

    private static int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result.val;
    }

    private static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        count--;
        if (count == 0) {
            result = root;
        }
        inorder(root.right);
    }
}
