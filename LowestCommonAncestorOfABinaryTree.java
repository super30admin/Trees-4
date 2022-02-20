//  Time Complexity: O(n)
//  Space Complexity: O(n) for recursive stack

public class LowestCommonAncestorOfABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //  base
        if (root == null || root == p || root == q) {
            return root;
        }

        //  logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }
        else if (left == null && right != null) {
            return right;
        }
        else if (left != null && right == null){
            return left;
        }
        else {
            return root;
        }
    }
}
