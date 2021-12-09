// 235 Lowest Common ancestor of a Binary Search Tree
// Solved on Leetcode
// Time complexity O(n)
// Space complexity O(n)

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
        
        if(root==null){
            return null;
        }
        
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return root;
        }
    }
}