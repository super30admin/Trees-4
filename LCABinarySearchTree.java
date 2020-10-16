/* 235. Lowest Common Ancestor of a Binary Search Tree - EASY
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

Did this code successfully run on Leetcode : Yes

Approach: If the 2 nodes lie on either sides of the root, or if one of them is the parent,
then the root is the least common ancestor.
If both the nodes lie in the left subtree, the root is in the left part.
If both the nodes lie in the right subtree, the root is in the right part.

TC: O(h) - we will process either the left or the right side of the tree. 
In worst case, for a skewed tree, we'll have to process all the node. 
This can be said as O(h).

SC: O(h) - stack space for recursion, O(1) for iterative solution
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LCABinarySearchTree {
    // Recursive
    public TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorRec(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorRec(root.right, p, q);
        } else {
            return root;
        }
    }

    // Iterative
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        TreeNode node = root;
        
        while (true) {
            if (p.val < node.val && q.val < node.val) {
                node = node.left;
            } else if (p.val > node.val && q.val > node.val) {
                node = node.right;
            } else {
                break;
            }
        }
        
        return node;
    }
}
