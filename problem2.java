package s30.Trees-4;

public class problem2 {
    class Solution {
        //TC:- O(h)
        //TC:- O(h)
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) return null;
            
            if(root.val > p.val && root.val > q.val){
                return lowestCommonAncestor(root.left,p,q);
            }else if(root.val < p.val && root.val < q.val){
                return lowestCommonAncestor(root.right,p,q);
            }else{
                return root;
            }
        }
    }
}
