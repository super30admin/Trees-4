/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Time complexity : O(n)
 * Space complexity : O(H) -- > stack space
 */
class Solution {
    
    int result = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        //base case
        if(root == null){
            return 0;
        }
        
        count = k;
        helper(root);
        return result;
        
    }
    
    private void helper(TreeNode root){
        
        //base case
        if(root == null){
            return;
        }
        
        //logic
        helper(root.left);
        
        count = count-1;
        
        if(count == 0){
            result = root.val;
        }
        
        helper(root.right);    
    
        
        
    }
}