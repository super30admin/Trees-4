// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach -
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null)
            return null;
        else if (left == null && right != null)
            return right;
        else if (left != null && right == null)
            return left;
        else
            return root;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach - store the root
// value in arraylist at each recursion, the root before the first point of
// mismatch in result lists is the lca
class Solution {
    ArrayList<ArrayList<TreeNode>> res = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list = new ArrayList<>();
        lca(root, p, q, list);

        ArrayList<TreeNode> l1 = res.get(0);
        ArrayList<TreeNode> l2 = res.get(1);
        for (int i = 0; i < l1.size(); i++) {
            if (i == l2.size())
                return l2.get(i - 1);
            else if (l1.get(i) != l2.get(i)) {
                return l1.get(i - 1);
            } else if (i == l1.size() - 1)
                return l1.get(i);
        }
        return root;
    }

    public void lca(TreeNode root, TreeNode p, TreeNode q, ArrayList<TreeNode> list) {
        if (root == null)
            return;

        list.add(root);
        if (root.val == p.val || root.val == q.val) {
            res.add(new ArrayList<>(list));
        }

        lca(root.left, p, q, list);
        lca(root.right, p, q, list);
        list.remove(list.size() - 1);

        return;
    }
}