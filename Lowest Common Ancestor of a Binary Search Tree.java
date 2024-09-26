// Time Complexity : O(N)
// Space Complexity : O(N) for the recursion stack
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
       if(root ==null){
          return null;
       }
           int pval=p.val;
           int qval=q.val;
           int rootval=root.val;
           
           if(pval < rootval && qval < rootval){
               return lowestCommonAncestor(root.left,p,q);
           }
             if(pval > rootval && qval > rootval){
               return lowestCommonAncestor(root.right,p,q);
           }
           return root;
      
    }
}