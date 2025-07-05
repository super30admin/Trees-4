// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
// 1. We recursively search for the nodes p and q in the left and right subtrees of the root.
// 2. If both nodes are found in different subtrees, the root is the lowest common ancestor (LCA).
// 3. If one of the nodes is found, we return that node; if both are not found, we return null.

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
        if (root==null){ return null;}
        //If either p or q is the root then root is the LCA
        if (root==p || root==q) {return root;}
        //Recursively search for p and q in the left and right subtrees
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //If both left and right are not null then root is the LCA
        if(left!=null && right!=null){ return root;}
        //If either left or right is null then return the other one
        //This means that both p and q are on one side of the tree
        if(left!=null){
            return left;
        }else {
            return right;
        }
    }
}