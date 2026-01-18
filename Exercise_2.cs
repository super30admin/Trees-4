// Time complexity Of solution is  O(N) Number od nodes worst case we will travsal all nodes 
// Space Complexity : O(1) I am not using any extra spave
//

ppublic class Solution {
    TreeNode result = null;
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
            bst(root,p,q);
            return result;
    }

    public void bst(TreeNode root,TreeNode p,TreeNode q){
        if(root==null) return;

        if(p.val < root.val && q.val < root.val){
            bst(root.left,p,q);
        }
         else if(p.val>root.val && q.val > root.val){
            bst(root.right,p,q);
        }
        else {
            result = root;
        }

       
    }
}