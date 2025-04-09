// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        backtrack(root, p, path1);
        backtrack(root, q, path2);
        for (int i = 0; i < path1.size(); i++) {
            if (i == path1.size() || path1.get(i) != path2.get(i))
                return path1.get(i - 1);
        }
        return path1.get(path1.size() - 1);
    }

    private void backtrack(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == null)
            return;
        if (root == p) {
            path.add(root);
        }
        path.add(root);
        backtrack(root.left, p, path);
        if (path.get(path.size() - 1) == p)
            return;
        backtrack(root.right, p, path);
        if (path.get(path.size() - 1) == p)
            return;
        path.remove(path.size() - 1);
    }
}
