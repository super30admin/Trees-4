public class LCA_BST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Both p and q can lie on the left if they're < root.
     * Both p and q can lie on the right if they're > root.
     * OR
     * They can lie on the opposite sides -> hence, root == lca.
     * <p>
     * if at any moment p or q == root --> return root as it itself is the LCA
     * NOTE: we can ommit this case as split or equal both return root, so anyhow we return just root.
     * <p>
     * TC: O(H)
     * SC: O(H)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        // redundant
//        if (root.val == p.val || root.val == q.val) {
//            return root;
//        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    /**
     * Avoid stack space by following an iterative solution
     * TC: O(H)
     * SC: O(1)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor_better(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
