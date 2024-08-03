/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Using DFS
        // if(root == null) {
        //     return root;
        // }
        // pathP = new ArrayList<>();
        // pathQ = new ArrayList<>();
        // dfs(root, p, q, new ArrayList<>());
        // for(int i = 0; i < pathP.size(); i++) {
        //     if(pathP.get(i) != pathQ.get(i)) {
        //         return pathP.get(i - 1);
        //     }
        // }
        // return null;

        // Using Bottom up Recurrsion
        return lca(root, p, q);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if(left == null && right == null) {
            return null;
        } else if(left != null && right == null) {
            return left;
        } else if(left == null && right != null) {
            return right;
        } else {
            return root;
        }
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base
        if(root == null || (pathP.size() > 0 && pathQ.size() > 0)) {
            return;
        }

        // logic
        //  action
        path.add(root);
        if(root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(root); // adding it twice
            // should not add return statement here as it would prevent the backtrack step
        }
        if(root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(root); // adding it twice
            // should not add return statement here as it would prevent the backtrack step
        }
        // recurse
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        // backtrack
        path.remove(path.size() - 1);
    }
}
