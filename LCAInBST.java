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
// Time Complexity : O(logN) N: nodes of Tree
// Space Complexity : O(logN)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 Recursion:
 1. Do recursion such that p,q are placed in a BST p<root.val<q
 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val <root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val > root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else
            return root;
        
    }
}


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
// Time Complexity : O(logN) N: nodes of Tree
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 Iterative:
 1. Do recursion such that p,q are placed in a BST (p.val<root.val<q.val)
 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val ) root = root.right;
            else return root;
        }
        return null; 
    }
}