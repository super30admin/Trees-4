import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem 235: Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Time Complexity: O(H) where H is the height of the tree
 * Space Complexity: O(H) for the recursion stack
 * Path comparison approach
 */
public class LCABST {
    List<Integer> path1 = new ArrayList<>();
    List<Integer> path2 = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findPath(root, p, path1);
        findPath(root, q, path2);

        System.out.println(path1);
        System.out.println(path2);

        // if path have different lengths then increase the length of the samller one by
        // adding dummy values
        for (int i = 0; i < Math.abs(path1.size() - path2.size()); i++) {
            if (path1.size() < path2.size()) {
                path1.add(-1);
            } else {
                path2.add(-1);
            }
        }

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

        path.add(root.val);
        // traverse using the properties of BST
        if (s.val < root.val) {
            findPath(root.left, s, path);
        } else if (s.val > root.val)
            findPath(root.right, s, path);

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
        // Test cases can be added here
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.right; // Node with value 8
        LCABST lcaBST = new LCABST();
        TreeNode lca = lcaBST.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val); // Expected LCA is 6

        p = root.left.left; // Node with value 2
        q = root.left.right.left; // Node with value 8
        lcaBST = new LCABST();
        lca = lcaBST.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val); // Expected LCA is 6

        // 6,2,8,0,4,7,9,null,null,3,5 p =2 q=4 LCA=2
        // additional test case
        p = root.left; // Node with value 2
        q = root.left.right; // Node with value 4
        lcaBST = new LCABST();
        lca = lcaBST.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val); // Expected LCA is 2

        // additional test case
        p = root.left.right.left; // Node with value 3
        q = root.left.right.right; // Node with value 5
        lcaBST = new LCABST();
        lca = lcaBST.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val); // Expected LCA is 4

    }
}
