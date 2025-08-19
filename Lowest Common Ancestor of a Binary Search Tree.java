// Time Complexity : O(h), where h is the height of the BST (O(log n) for a balanced tree, O(n) in the worst case of a skewed tree), since we traverse down at most one path from the root.
// Space Complexity : O(1), iterative approach uses constant extra space.
// Did this code successfully run on Leetcode : Yes

// Approach :
// This solution exploits the BST property: for any node, all left-subtree values are smaller and all right-subtree values are larger.
// Starting at the root, if both p.val and q.val are smaller than root.val, the LCA must be in the left subtree, so move left.
// If both are larger than root.val, the LCA must be in the right subtree, so move right.
// Otherwise, the current root is exactly where p and q split (or equals one of them), which makes it the LCA.
// The loop continues until it finds that split point and returns the node.

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
        if(root == null) return null;
        while(root != null){
            if(root.val > p.val && root.val > q.val)
                root = root .left;
            else if( root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }
}
