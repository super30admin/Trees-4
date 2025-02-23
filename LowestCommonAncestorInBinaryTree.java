import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 * Did this code successfully run on Leetcode: Yes/No
 * Any problem you faced while coding this: None

 * Approach:
 * Approach - 1: 
 * Find the ancestor bottom up, if the child nodes are null, take actions based on what the ancestor should be in this case
 * 
 * Approach - 2
 * Maintain a path for the p and q nodes and then check which is the last index that had shared node among both paths
 */

public class LowestCommonAncestorInBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Approach 1: Bottom up recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    // Approach 2: DFS
    List<TreeNode> pathP, pathQ;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        dfs (root, p, q, new ArrayList<>());

        for (int i = 0; i < pathQ.size(); i++) {
            if (pathP.get(i) != pathQ.get(i)) {
                return pathQ.get(i - 1);
            }
        }
        return root;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base
        if (root == null)
            return;
        // logic
        path.add(root);
        if (root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }

        if (root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }

        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        // Your code here
        LowestCommonAncestorInBinaryTree obj = new LowestCommonAncestorInBinaryTree();
        TreeNode n4 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, new TreeNode(1), n4);
        TreeNode n1 = new TreeNode(4, n2, new TreeNode(5));
        TreeNode result = obj.lowestCommonAncestor(n1, n2, n4);
        System.out.println(result.val);
    }
}