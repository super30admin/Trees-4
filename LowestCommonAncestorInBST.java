// Time Complexity : O(h) h is the height of the tree.
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Approach : We compare the root with p and q values and decide to either navigate towards left or right part of the subtree as it's a binary search tree.
// Once we find p or q at the node, that node will be the common ancestor.


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) { // p and q are on left subtree
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) { //p and q are on right subtree
            return lowestCommonAncestor(root.right, p, q);
        } else{
            return root;
        }
    }
}