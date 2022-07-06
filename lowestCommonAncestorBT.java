// Time Complexity :O(n)
// Space Complexity :height of the tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    private List<TreeNode> path1;
    private List<TreeNode> path2;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        helper(root, p, q, new ArrayList<>());
        // traverse through both paths, where path becomes different we found common
        // ancestor
        for (int i = 0; i < path1.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                return path1.get(i - 1);
            }
        }
        return null;
    }

    public void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // edge
        if (root == null) {
            return;
        }
        // logic
        // action
        // add curr to path
        path.add(root);
        if (root == p) {
            // if we found one of the nodes,copy path in path1/path2 and add one extra node
            // to
            // not check if common ancestor is one of the given nodes
            path1 = new ArrayList<>(path);
            path1.add(p);
        } else if (root == q) {
            path2 = new ArrayList<>(path);
            path2.add(p);
        }

        // traverse through tree
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);
        // backtrack
        path.remove(path.size() - 1);
    }
}