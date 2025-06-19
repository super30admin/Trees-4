
/**
 * LeetCode Problem: 235. Lowest Common Ancestor of a Binary Search Tree
 * 
 * Approach:
 * - In a Binary Search Tree (BST), the left subtree contains values less than the root, and the right subtree contains values greater than the root.
 *  - To find the lowest common ancestor (LCA) of two nodes p and q:
 *  - If both p and q are less than the root, then LCA lies in the left subtree.
 *  - If both p and q are greater than the root, then LCA lies in the right subtree.
 *  - If one of p or q is less than the root and the other is greater, then the root is the LCA.
 * 
 * * Time Complexity: O(H) where H is the height of the tree.
 * * Space Complexity: O(1) for the iterative approach or O(H) for the recursive approach due to the recursion stack.
 */
public class LCA_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
