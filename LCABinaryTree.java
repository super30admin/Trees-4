public class LCABinaryTree {


    /*
    TC : O(N) where N is the number of nodes
    SC : O(H) where H is the height of the tree
    LC : yes
    Problems :  No
     */

    /**
     * Here, we use the fact that for the recursive call of the LCA, both the left and right recursive calls will return a node that is found
     * In cases where one of the nodes if the parent of another node, we will get a valid node for one of the left or right recursive calls
     * and get null for one of the recursive calls.
     * So in that case, we return whichever value is not null
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }
}
}
