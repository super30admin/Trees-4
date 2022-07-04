//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Time Complexity :O(n)  
// Space Complexity :O(h) //stack space at any time we will have height no of nodes in stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
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
        //base 
        if(root==null||root==p||root==q)
            return root;
        //logic
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //action
        if(left!=null && right!=null)
            return root;//means p is at left and q is at right return parent
        else if(left==null && right!=null)
            return right;//right node is found
        else if(left!=null && right==null)
            return left; //left node is found
        else //both the nodes are not found
            return null;
        
    }
}