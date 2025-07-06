/**
 * Leetcode 235. Lowest Common Ancestor of a Binary Search Tree
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
// ------------------------- Solution 1 --------------------------------
public class LowestCommonAncestorBST {
    /**
     * Use BST property to navigate the side on which both p and q are present. Along the way if both p and q
     * are not on the same side of the subtree, that means the current node is the least common ancestor
     *
     * TC: O(n) traverse all nodes worst case
     * Auxiliary SC: O(1)
     * Recursive stack SC: O(h) h -> height of the tree, worst case O(n), complete BST O(log n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}

// ------------------------- Solution 2 --------------------------------
class LowestCommonAncestorBST2 {
    /**
     * Our previous approach is a simple top down tree traversal, this can be easily translated into an iterative solution
     * with iteration running until we reach leaf node (actually its children) and meanwhile check if both p and q lie on
     * the same side of the subtree, if not current node is the LCA. No recursive stack space used in this solution
     *
     * TC: O(n)
     * SC: O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        while(root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else { // we are standing at LCA
                return root;
            }
        }
        return null;
    }
}