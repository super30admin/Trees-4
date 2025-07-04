// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES

public class LCA_BT {
    // 3,5,1,6,2,0,8,null,null,7,4

    public static void main(String[] args) {
        TreeNode root = buildTree();
        TreeNode p = root.left; // node with val = 5
        TreeNode q = root.left.right.right;

        TreeNode treeNode = lca_bt(root, p , q);
        System.out.println("LCA_BT: " + treeNode.val);
    }

    private static TreeNode lca_bt(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lca_bt(root.left, p, q);
        TreeNode right = lca_bt(root.right, p , q);

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        return root;
    }

}
