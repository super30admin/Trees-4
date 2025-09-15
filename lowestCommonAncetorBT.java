class Solution {
    // Idea is to use dfs to find the treenode's p and q as child nodes to current node
    // return the node to the upper root nodes
    // Time Complexity: O(n)
    // Space Complexity: O(logn)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      return traversal(root,p,q);  
    }
    public TreeNode traversal(TreeNode root,TreeNode p,TreeNode q){
      if(root==null){
          return null;
      }
      else{
            if(root==p)
                return p;
            if(root==q)
                return q;
          
            TreeNode leftae=traversal(root.left,p,q);
            TreeNode rightae=traversal(root.right,p,q);
                if(leftae!=null&&rightae!=null){
                     return root;
                 }
                 else if(leftae!=null)
                 {
                     return leftae;
                 }
                 else if(rightae!=null){
                     return rightae;
                 }
                 else
                 {
                     return null;
                 }
         }
    }
}