//time complexity- O(n)
//space complexity- O(h)
public class LowestCommonAncestorInBT {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) return null;
        if(left == null && right != null) return right;
        if(left != null && right == null) return left;

        return root;
    }
    public static void main(String[] args) {
        /*  Binary Tree
                    3
                  /  \
                 5    1
               / \   / \
              6   2 0   8
                 / \
                7   4
         */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println("LCA of " + p.val + " and " + q.val + "  is " + lowestCommonAncestor(root, p, q).val);
    }
}
