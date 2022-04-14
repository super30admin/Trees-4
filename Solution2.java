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
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
     if(p==null || q==null || node==null){
         return node;
     }   
     if((node.val >= p.val && q.val >= node.val) || node.val <= p.val && q.val <= node.val){
         return node;
     }   
       
        TreeNode rr = null;
      if(p.val <= node.val){  
        rr = lowestCommonAncestor(node.left, p, q);  
          }else{
          rr = lowestCommonAncestor(node.right, p, q);
      }
        
        return rr;
    }
}
