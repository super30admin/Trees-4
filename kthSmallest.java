// Time Complexity :O(H)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach : 
Knowing the properties of binary search tree i.e. smaller elements are on left side we will go to all the element on left subtree and if K becomes 0 it means we found our result else go to the right subtree.

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
    public int kthSmallest(TreeNode root, int k) {
          if(root == null)
            return -1;        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = root.left;
        
        while(true) {        
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }      
            curr = stack.pop();           
            if(--k == 0) 
                return curr.val;           
            curr = curr.right;
        }
    }   
}
        
