/**
 * LeetCode Problem 235: Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Time Complexity: O(H) where H is the height of the tree
 * Space Complexity: O(H) for the recursion stack
 * DFS approach leveraging the properties of BST
 */
public class LCABST1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) { // if both p and q are smaller than root, then LCA lies in left
                                                    // subtree
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) { // if both p and q are greater than root, then LCA lies in
                                                           // right subtree
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root; // we have found the split point, i.e., the LCA node
        }
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
}
