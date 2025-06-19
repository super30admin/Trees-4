/**
 * Find the Lowest Common Ancestor (LCA) of two nodes in a binary tree.
 * Approach:
 * - We can use a recursive approach to find the LCA.
 * - If the current node is null, we return null.
 * - If the current node matches either of the nodes p or q, we return the current node.
 * - We recursively search for p and q in the left and right subtrees.
 * - If both left and right recursive calls return non-null values, the current node is the LCA.
 * - If only one of the recursive calls returns a non-null value, we return that value.
 * 
 * * Time Complexity: O(N) where N is the number of nodes in the tree.
 * * Space Complexity: O(H) where H is the height of the tree (due to recursion stack).
 * 
 */
public class LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
