import java.util.ArrayList;
import java.util.List;

public class LCAInBT {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    List<TreeNode> pathp, pathq;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        helper(root, p, q, new ArrayList<>());

        for (int i = 0; i < pathp.size(); i++) {
            if (pathp.get(i) != pathq.get(i)) {
                return pathp.get(i - 1);
            }
        }
        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        if (root == null || (pathp != null && pathq != null))
            return;

        path.add(root);

        if (root == p) {
            pathp = new ArrayList<>(path);
            pathp.add(root);
        }
        if (root == q) {
            pathq = new ArrayList<>(path);
            pathq.add(root);
        }

        helper(root.left, p, q, path);
        helper(root.right, p, q, path);

        path.removeLast();
    }
}

//TC: O(n) , SC: O(h) + O(h)


//Approach - 2

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null)
            return null;
        else if (left != null && right == null)
            return left;
        else if (left == null && right != null)
            return right;
        else
            return root;
    }
}

//TC; O(n), SC: O(h)