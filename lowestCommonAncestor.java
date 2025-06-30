class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(p.val<q.val)
      return search(root,p,q);
      else 
      return search(root,q,p);

        
    }

    public static TreeNode search(TreeNode root,TreeNode p,TreeNode  q){
        if(root==null){
            return null;
        }
        else{
            TreeNode ans=null;
            if(root.val>q.val){
                ans= search(root.left,p,q);
            }
            else if(root.val<p.val){
                 ans=search(root.right,p,q);
            
            }
            if(ans!=null) return ans;
           else if(root.val>p.val && root.val<q.val){
                return root;
            }
            else if(root==p  ||  root==q){
                return root;
            }
            else return null;
            
        }
    }
}