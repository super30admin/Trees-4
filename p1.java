// Time Complexity : O(k)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
        //Stack to keep track of which nodes to process
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        //Count to keep track of when we reach the kth smallest element
        int count = 0;
        //Iterate till we reach the kth smallest node
        while(root != null || stk.peek() != null){
            while(root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            count++;
            if(count == k) return root.val;
            root = root.right;
        }

        return -1;
    }
}