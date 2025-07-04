// Time Complexity : O(H)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class LCA_BST {
    public static void main(String[] args) {
        TreeNode root = buildTree();

//        TreeNode treeNode = lca_bst(root, new TreeNode(2), new TreeNode(8));
//        System.out.println("LCA_BST : " + treeNode.val);

        TreeNode treeNode2 = lca_bst(root, new TreeNode(4), new TreeNode(5));
        System.out.println("LCA_BST : " + treeNode2.val);
    }

    private static TreeNode lca_bst(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }

    // Constructing the same 12-node tree we discussed
    private static TreeNode buildTree() {
        // 6,2,8,0,4,7,9,null,null,3,5
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        return root;
    }

}
