public class KthSmallestInBST {
    int k;
    int result;

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public void inOrder(TreeNode node) {
        if (node == null) return;

        // first left node
        inOrder(node.left);

        // then process curr node
        // while going inOrder, if class variable k hits 0
        // set result to node val & return
        if (--k == 0) {
            result = node.val;
            return;
        }

        // then right node
        inOrder(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {

        // set class variable k
        this.k = k;

        // do inOrder from root
        inOrder(root);

        // return result
        return result;
    }
}