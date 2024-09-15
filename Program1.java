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
//Time Complexity : O(logn)
//Space Complexity : O(1)

class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
        int num = count(root.left);
         if(k==num+1){
             return root.val;
         }else if(k<num+1){
             return kthSmallest(root.left,k);
         }else{
             return kthSmallest(root.right,k-num-1);
         }
        
    }
    
    private int count(TreeNode root){
        
        if(root==null){
            return 0;
        }else{
            return 1+count(root.left)+count(root.right);
        }
    }
}