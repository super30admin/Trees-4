// Time Complexity : O(h) -- where h is height of tree
// Space Complexity : O(h) -- where h is height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class LowestCommonAncestorInBinaryTree {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backtrack(root, p, q, new ArrayList<>());
        // compare and find uncommon element
        for (int i = 0; i < pathP.size(); i++) {
            if (pathP.get(i) != pathQ.get(i))
                return pathP.get(i - 1);
        }
        return null;
    }

    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base
        if (root == null) {
            return;
        }

        // Action
        path.add(root);
        if (root == p) {
            this.pathP = new ArrayList<>(path);
            pathP.add(p);
        }
        if (root == q) {
            this.pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }
        // recurse on left
        backtrack(root.left, p, q, path);
        // recurse on right
        backtrack(root.right, p, q, path);
        // backtrack
        path.remove(path.size() - 1);

    }
}
