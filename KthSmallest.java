// Time Complexity : O(h + k)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

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

// We traverse the Binary Search Tree using dfs inorder traversal
// Simultaneously we decrement the value of k after visiting each node
// When k == 0, we return the value of the node
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null) return -1;
        
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || !stack.isEmpty()) {
            
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            k--;
            
            if(k == 0) return root.val;
            
            root = root.right;
        }
        return -1;
    }
}