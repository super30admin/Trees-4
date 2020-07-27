/**
 * Time complexity : O(n) where n = number of nodes
 * Space complexity : O(h) where h = Height of the tree
 */

public class LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p,  q);
        TreeNode right = lowestCommonAncestor(root.right,  p,  q);

        if(left != null && right != null) return root;
        if(left == null) return right;
        else return left;
    }
}