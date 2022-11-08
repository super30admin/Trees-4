package s30.Trees-4;

public class problem3 {
    //TC:- O(n)
    //SC:- O(n)
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
           if (root == null || root == p || root == q) {
               return root;
           }
            
            TreeNode leftSide = lowestCommonAncestor(root.left, p, q);
            TreeNode rightSide = lowestCommonAncestor(root.right, p, q);
            
           if (leftSide != null && rightSide != null) {
               return root;
           } else if (leftSide == null) {
               return rightSide;
           } else {
               return leftSide;
           }
        }
    }
}
