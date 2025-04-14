import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
/*
TC -> O(N+H)
SC -> O(H)
*/
class Solution1 {
    List<TreeNode> path_P;
    List<TreeNode> path_Q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        path_P = new ArrayList<>();
        path_Q = new ArrayList<>();
        dfs(root, p, q, new ArrayList<>());
        for (int i = 0; i < path_P.size(); i++) {
            if (path_P.get(i) != path_Q.get(i)) {
                return path_P.get(i - 1);
            }
        }
        return null;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base
        if (root == null) {
            return;
        }
        // logic
        path.add(root);
         if (root == p) {
            path_P = new ArrayList<>(path);
            path_P.add(p);
        }
        if (root == q) {
            path_Q = new ArrayList<>(path);
            path_Q.add(q);
        }
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        path.remove(path.size() - 1);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
/*
TC -> O(H)
SC -> O(H)
*/
class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left == null && right != null) {
            return right;
        } else if (right == null && left != null) {
            return left;
        } else {
            return root;
        }

    }
}