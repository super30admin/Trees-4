class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) {
            return root;
        }
        TreeNode left, right;
        left = lowestCommonAncestor(root.left, p, q);
        right = lowestCommonAncestor(root.right, p, q);
        if(right != null && left != null) {
            return root;
        } else if(left != null) {
            return left;
        } else {
            return right;
        }
    }
}