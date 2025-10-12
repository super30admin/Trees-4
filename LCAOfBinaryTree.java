//TC: O(n), SC: O(n)
//Approach: Bottom up recursion
public class LCAOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        if (left == null && right == null) return null; //if both left and right are null, return null
        else if (left == null) return right; //left is null, right won't be null because we already checked that on line 14
        else if (right == null) return left; //right is null, left won't be null because we already checked that on line 14
        else return root; //if we both left and right are not null, we are standing on the LCA aka root
    }
}
