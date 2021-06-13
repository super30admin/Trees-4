//Time complexity O(n)
//Space complexity O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

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
//Logic Iterate in preorder fashion and add a counter for each level to know the index.
class Solution {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
    result = 0;
    count = 0;
      helper(root, k);
      return result; 
    }
   private void helper(TreeNode root, int k){
      if(root == null){
            
            return ;
        }
        
        helper(root.left, k);
        count ++;
       //System.out.println(count);
        if(k == count){
            
           result = root.val;
            return;
        }
        
        helper(root.right, k);
    }
}