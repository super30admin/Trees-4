// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
 Using recursive approach and using BST tree properties if both values are smaller than go to left side if both values are bigger then go to right side if one value is bigger and the other is smaller it means root is the ans.
*/

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
      
        while(true)
        {
         if(p.val < root.val && q.val < root.val)
            root = root.left;
        else if (p.val > root.val && q.val > root.val)
             root = root.right;
        else 
            return root;
        }
        
       // return null;
    }
    
    /* if(p.val < root.val && q.val < root.val)
           return lowestCommonAncestor(root.left,p,q);
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right,p,q);
        else 
            return root;*/
  
}