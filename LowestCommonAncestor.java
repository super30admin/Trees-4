public class LowestCommonAncestor {

    /*
    TC : O(N)
    SC :O(N)
     */

    /**
     * Here, we use the BST property and if both are less than root then continue the search in root.left
     * Else if both are greater than the root, then continue the search with root.right as the root
     * else return root as both are on different sides of root and hence the current root is the LCA
     */

    public TreeNode lowestCommonAncestor_using_recursion(TreeNode root, TreeNode p, TreeNode q) {


        int pVal = p.val;
        int qVal = q.val;

        int rootVal = root.val;

        if (pVal < root.val && qVal < root.val)
            return lowestCommonAncestor(root.left, p, q);

        else if (pVal > root.val && qVal > root.val)
            return lowestCommonAncestor(root.right, p, q);

        else
            return root;


    }


    /**
     * Iterative solution for the same approach as above
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor_iterative_solution(TreeNode root, TreeNode p, TreeNode q) {

        while (true) {

            int pVal = p.val;
            int qVal = q.val;

            int rootVal = root.val;

            if (pVal < root.val && qVal < root.val)
                root = root.left;

            else if (pVal > root.val && qVal > root.val)
                root = root.right;

            else
                return root;
        }


    }

}