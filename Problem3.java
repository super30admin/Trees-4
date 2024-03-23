//Accepted onLT
class Solution {
    List<TreeNode> p1;
    List<TreeNode> q1;
    int pfound = 0;
    int qfound = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if(root==null || root==p || root==q) return root;

        //recurse
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null && right==null){
            return null;
        }
        else if(left==null && right!=null){
            return right;
        }
        else if(left!=null && right==null){
            return left;
        }
        return root;
        
       
    }
    
}
