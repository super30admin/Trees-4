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


    /*
    TC : O(N) where N is the number of nodes
    SC : O(logN)
     */

    /**
     * We find the path from root to both p and Q and then find the common ancestor.
     * The only catch is to find the common ancestors after getting the paths, we add p and q twice in both the paths to avoid
     * out of bound exceptions
     */
    List<TreeNode> pathP = new ArrayList<TreeNode>();
    List<TreeNode> pathQ = new ArrayList<TreeNode>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        helper(root, p, q, new ArrayList<TreeNode>());
        return findLCA(pathP, pathQ);

    }

    public TreeNode findLCA(List<TreeNode> pathP, List<TreeNode> pathQ) {
        int i = 1;
        int j = 1;
        while (i < pathP.size() && j < pathQ.size() && pathP.get(i) == pathQ.get(j)) {
            i++;
            j++;
        }
        return pathP.get(i - 1);

    }

    public void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {

        if (root == null)
            return;

        path.add(root);
        if (root == p) {

            pathP.addAll(path);
            pathP.add(root);

        }

        if (root == q) {
            pathQ.addAll(path);
            pathQ.add(root);

        }

        helper(root.left, p, q, path);

        if (pathP.size() > 0 && pathQ.size() > 0) {

        } else
            helper(root.right, p, q, path);

        path.remove(path.size() - 1);
    }

}
