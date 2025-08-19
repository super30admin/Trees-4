// Time Complexity : O(n), where n is the number of nodes in the tree, since in the worst case we may visit every node once in the recursive search.
// Space Complexity : O(h), where h is the height of the tree (O(log n) for a balanced tree, O(n) in the worst case of a skewed tree), due to the recursion stack.
// Did this code successfully run on Leetcode : Yes

Approach :

// This solution works for any binary tree (not necessarily a BST).
// If the current root is null, p, or q, it directly returns root because either no node exists here or one of the targets is found.
// It recursively checks both left and right subtrees for p and q.
// If both left and right recursive calls return non-null, it means p was found in one subtree and q in the other, making the current root their lowest common ancestor.
// Otherwise, whichever side is non-null is returned upward, meaning both targets are contained in that subtree.

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
