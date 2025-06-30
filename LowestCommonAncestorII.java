class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p){
            return p; 
        }
        else if(root==q){
            return q;
        }
        else if(root==null){
            return null;
        }
        else{
            TreeNode l=lowestCommonAncestor(root.left,p,q);
            TreeNode r=lowestCommonAncestor(root.right,p,q);
            if(r==null){
                return l;
            }
            else if(l==null){
                return r;
            }
            else return root;
        }
    }
}