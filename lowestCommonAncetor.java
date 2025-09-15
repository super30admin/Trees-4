class Solution {
    //Idea is to check left and right sub trees to find p and q systematically based on root's value
    //return root's value if it falls in the range
    //Time Complexity: O(logn)
    //Space Complexity: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      
    return recur(root,p,q);
       
    }
    public TreeNode recur(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)
        {
            return null;
        }
       else if(root.val<p.val&&root.val<q.val){
           return recur(root.right,p,q);
        }
      else  if(root.val>p.val&&root.val>q.val){
            return recur(root.left,p,q);
        }
      else{
          return root;
        }
    }
}
