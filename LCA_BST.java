// Time Complexity :O(log n) // n-number of nodes
// Space Complexity :O(h) - Stack space // h- maximum height of the tree 
// Did this code successfully run on Leetcode :yes 
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

//Recursive Approach
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
      if(root==null) return  null;
      if(p.val<root.val && q.val<root.val)
      {
          return lowestCommonAncestor(root.left,p,q);
      }else if(p.val>root.val && q.val>root.val)
      {
          return lowestCommonAncestor(root.right,p,q);
      }else
          return root;
    }
}

//Iterative Approach
TC: O(log n)
SC: O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null)
        {
          if(p.val<root.val && q.val<root.val)
          {
              root=root.left;
          }else if(p.val>root.val && q.val>root.val)
          {
              root=root.right;
          }else
              return root;
        }
        
       return null;

    }
}