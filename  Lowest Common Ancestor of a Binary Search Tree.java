/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//take p, q compare with root and go accordingly traversing the tree, if smaller than root go left, if bigger
//go right, if both side root is answer, tc- O(logn) because cutting down search to half every comparison
//sc- stck space for recurssion or O(1) for iterative


//recurssive
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//       if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
//       else if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
//       else return root;
//     }
// }

//iterative
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       while(true){
         if(p.val < root.val && q.val < root.val) root = root.left;
         else if(p.val > root.val && q.val > root.val) root = root.right;
         else return root;

       } 
     
    }
}