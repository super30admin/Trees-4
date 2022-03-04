/**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
*/

// Time Complexity :o(n)
// Space Complexity :o(H)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
       if(root == null) return null;
       return helper(root, p, q);   
   }
   
   private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) 
   { 
       //logic
       if(root.val > p.val && root.val > q.val)
       {
           return helper(root.left, p, q);
       }
       if(root.val < p.val && root.val < q.val)
       {
           return helper(root.right, p, q);
       }
       return root;
       
   }
}class LCA_BST {
    
}
