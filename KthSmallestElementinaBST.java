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
    int cnt, result;
    
    private void inorder(TreeNode root){
        //base
        if(root == null){
            return;
        }
        //logic
        inorder(root.left);
        //action
        //s.pop()
        cnt--;
        
        if(cnt == 0){
            result = root.val;
            return;
        }
        inorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null){
            return -1;
        }
        
        cnt = k;
        
        inorder(root);
        
        
        return result;
        
    }
}