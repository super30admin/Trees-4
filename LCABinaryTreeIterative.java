// Time Complexity O(n)
// Space Complexity O(h)

import java.util.*;

public class LCABinaryTreeIterative {
    public TreeNode LCAinBTIterative(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || p == null || q == null) {
            return null;
        }
        // Stack for tree node
        Stack<TreeNode> stack = new Stack<>();
        // path lists to store the path to nodes p and q
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        boolean foundP = false;
        boolean foundQ = false;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {   // traverse left subtree
                stack.push(root);
                root = root.left;

            }
            // visit node
            root = stack.pop();
            if (!foundP) {
                pathP.add(root);
                if (root == p) {
                    foundP = true;
                }
            }
            if (!foundQ) {
                pathQ.add(root);
                if (root == q) {
                    foundQ = true;
                }
            }
            // traverse right subtree
            if (foundP && foundQ) {
                break;
            }
        }
        // compare paths to find LCA

        int i = 0;
        while (i < pathP.size() && i < pathQ.size() && pathP.get(i) == pathQ.get(i)) {
            i++;
        }
        return pathP.get(i - 1); // backtrack
    }
    public static void main(String[] args) {
        // Manually constructing the binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Nodes for which we want to find the LCA
        TreeNode p = root.left;        // Node with value 5
        TreeNode q = root.left.right.right; // Node with value 4

        // Create an instance of the class
        LCABinaryTreeIterative tree = new LCABinaryTreeIterative();

        // Find LCA
        TreeNode lca = tree.LCAinBTIterative(root, p, q);

        // Print the result
        if (lca != null) {
            System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
        } else {
            System.out.println("No common ancestor found.");
        }
    }
}


