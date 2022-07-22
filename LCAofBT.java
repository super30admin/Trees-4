//Time : O(h)
//Space : O(h)
class Solution {
    List<TreeNode> pl;
    List<TreeNode> ql;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pl = new ArrayList<>();
        ql = new ArrayList<>();
        helper(root, p, q, new ArrayList<>(), new ArrayList<>());
        for (int i = 0; i < pl.size(); i++) {
            if (pl.get(i) != ql.get(i)) {
                return pl.get(i - 1);
            }
        }
        return null;

    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> pli, List<TreeNode> qli) {
        // base
        if (root == null)
            return;
        // logic
        pli.add(root);
        qli.add(root);
        if (root == p) {
            pli.add(root);
            pl = new ArrayList<>(pli);
        }
        if (root == q) {
            qli.add(root);
            ql = new ArrayList<>(qli);
        }

        helper(root.left, p, q, pli, qli);
        helper(root.right, p, q, pli, qli);
        pli.remove(pli.size() - 1);
        qli.remove(qli.size() - 1);
    }
}