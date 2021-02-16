// Time Complexity : O(n) n is number of nodes
// Space Complexity : O(h) h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


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
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        int count =0;
        while(true)
        {
            while(root!=null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            if(count == k)
            {
                return root.val;
            }
            root = root.right;
        }
       }
    
}
