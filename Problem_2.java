/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// check if the p and q are less than root then move towards the left, if p and q are grater than root then move towards right else return root( as either p is less then root and q is grater then, or p or q is root)
// Your code here along with comments explaining your approach
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q);
        else if( p.val < root.val && q.val < root.val ) return lowestCommonAncestor(root.left,p,q);
        else return root;
    }
}