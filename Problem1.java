/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
LeetCode Submitted : YES
Space Complexity : O(1) 
Time Complexity : O(Number of nodes in Tree)

The idea is to do inorder traversal and return first kth element in the traversal since its a BST.


**/

class Solution {
    int value;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null)
            return -1;
        
       
        
        return  findKthSmallest(root,k);
    }
    
    private int findKthSmallest(TreeNode root, int k){
        if(root == null)
            return -1;
        
        int res1 = findKthSmallest(root.left,k);
        
        
        count++;
        
        if(count == k){
            value = root.val;
            //return value;
        }else{
             int res2 = findKthSmallest(root.right,k);     
        }    
        return value;
    }
}
