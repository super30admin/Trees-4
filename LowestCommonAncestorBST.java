class LcaBST {
  /**
    Time Complexity: O(logn)
         -> We are able to reduce our search space by half in each iteration.
    
    Space Complexity: O(height)
       -> space taken by the recursive stack
        
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root.val < p.val && root.val < q.val){
          return lowestCommonAncestor( root.right,  p,  q);
      } else if (root.val > p.val && root.val > q.val){
          return lowestCommonAncestor(root.left,  p,  q);
      } else {
          return root;
      }
  }
}
