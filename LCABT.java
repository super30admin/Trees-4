import java.util.ArrayList;
import java.util.List;

/**
 * LEetCode Problem 236: Lowest Common Ancestor of a Binary Tree
 * URl: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class LCABT {
    List<Integer> path1 = new ArrayList<>();
    List<Integer> path2 = new ArrayList<>();
    boolean found = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findPath(root, p, path1);
        found = false;
        findPath(root, q, path2);

        // if path have different lengths then increase the length of the samller one by
        // adding dummy values
        for (int i = 0; i < Math.abs(path1.size() - path2.size()); i++) {
            if (path1.size() < path2.size()) {
                path1.add(path1.get(path1.size() - 1));
            } else {
                path2.add(path2.get(path2.size() - 1));
            }
        }

        System.out.println(path1);
        System.out.println(path2);

        for (int i = 0; i < path1.size(); i++) {
            if (!path1.get(i).equals(path2.get(i))) {
                return new TreeNode(path1.get(i - 1));
            }
        }
        return null;
    }

    private void findPath(TreeNode root, TreeNode s, List<Integer> path) {
        // base case
        if (root == null)
            return;

        if (root.val == s.val && !found) {
            found = true;
            path.add(root.val);
        }
        if (!found)
            path.add(root.val);
        // traverse using the properties of BST
        findPath(root.left, s, path);
        findPath(root.right, s, path);
        if (!found)
            path.remove(path.size() - 1);

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        LCABT lcaFinder = new LCABT();
        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.left.right.right; // Node with value 4
        TreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of nodes " + p.val + " and " + q.val + " is: " + lca.val); // Expected
                                                                                                              // LCA is
                                                                                                              // 5
        lcaFinder = new LCABT();
        p = root.left; // Node with value 5
        q = root.right; // Node with value 1
        lca = lcaFinder.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of nodes " + p.val + " and " + q.val + " is: " + lca.val); // Expected
                                                                                                              // LCA is
                                                                                                              // 3

    }

}
