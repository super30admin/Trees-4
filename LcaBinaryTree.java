//No backtracking
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       //base
        if(root == null || root == p || root == q){
            return root;
        }
        //logic

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //action

        if(left != null && right != null){
            return root;
        }
        else if(left == null && right != null){
            return right;
        }
        else if(left != null && right == null){
            return left;
        }
        else {
            return null;
        }
        
    }
}