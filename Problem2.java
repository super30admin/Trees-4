// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
//1. We check if both target nodes are on the left or right to decide the direction of the search following the property of BST.
//2. the root node is returned when one target node is on one side and the other target node is on the other side,
//3. if the root node itself is one of the target nodes.

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
        //if the recursion reaches the leaf node then return null
        //this is the base case of the recursion
        if(root==null) return null;
        //In a binary search tree, if both p and q are smaller than the root, then the LCA lies in the left subtree.
        if (root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        //If both p and q are greater than the root, then the LCA lies in the right subtree.
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        //If one of p or q is equal to root, then root is the LCA.
        else{
        return root;
        }

    }
}