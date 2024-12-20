/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int val=0;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
         int count=k;
         if(root==null)
         return 0;
         helper(root,k);
         return val;
         
    }

    void helper(TreeNode root, int k) {
         if(root==null)
         return;
         helper(root.left,k);
         count++;;
         if(k==count){
         val= root.val;
         return;
         }
         
         helper(root.right,k);
         
    }

}