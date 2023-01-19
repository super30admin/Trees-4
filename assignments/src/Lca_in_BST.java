// Time: O(n)
// Space: O(1)
class Lca_in_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int pVal = p.val, qVal = q.val;

        TreeNode node = root;

        while (node != null) {

            int nodeVal = node.val;
            if (nodeVal > pVal && nodeVal > qVal) {
                node = node.left;
            }
            else if (nodeVal < pVal && nodeVal < qVal) {
                node = node.right;
            }
            else return node;
        }
        return null;
    }
}