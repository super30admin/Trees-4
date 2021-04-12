// Time Complexity : O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
      
      if(root == null)
      {
        return null;
      }
      //root is the lca when it is equal to p or q
      if(root.val == p.val || root.val == q.val)
      {
        return root;
      }
      //lca at node which would break the two directions at which p and q are
      if((p.val<root.val && q.val>root.val)||(p.val>root.val && q.val<root.val))
      {
        return root;
      }
      //if p and q are less than root we go towards the left
      else if(p.val<root.val && q.val<root.val)
      {
        return lowestCommonAncestor(root.left,p,q);
      }
      //if p and q are more than root we go towards the right
      else
      {
        return lowestCommonAncestor(root.right,p,q);
      }
        
        
        
    }
}