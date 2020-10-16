/* Approach: 236. Lowest Common Ancestor of a Binary Tree - MEDIUM
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

Did this code successfully run on Leetcode : Yes

Approach: Return the node if its value is either p or q. Propagate this return value across to the parent.
If recursive calls for left and right return a non-null value, it means that p & q are in the left & right subtree.
And hence return root as the ancestor.

If left is non-null and right is null, then we report the left node as found & pass it on further to parent.
If right is non-null and left is null, then we report the right node as found & pass it on further to parent.
 
TC: O(n) - we may need to visit all nodes before we find p and q
SC: O(h) - max stack space
*/

public class LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}