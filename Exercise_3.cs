// Time complexity Of solution is  O(N) Number od nodes worst case we will travsal all nodes 
// Space Complexity : O(1) I am not using any extra spave
//

public class Solution {

    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      return  dfs(root,p,q);

     
    }

    public TreeNode dfs(TreeNode root,TreeNode p ,TreeNode q){
        if(root == null || root == p || root == q) return root;
        TreeNode left = dfs(root.left,p,q);
        TreeNode right = dfs(root.right,p,q);

        if(left== null && right == null){
            return null;
        }else if( left==null && right!=null){
            return right;
        }else if(right == null && left!=null){
            return left;
        }else{
            return root;
        }


    }
}