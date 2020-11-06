// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, 3ms
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// if both p and q are less than root, search in left subtree, else in the right subtree.

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
      if(p.val > root.val && q.val > root.val){
          return lowestCommonAncestor(root.right,p,q);
      }
      else if(p.val < root.val && q.val < root.val){
          return lowestCommonAncestor(root.left,p,q);
      }
      else{
          return root;
      }
}
}