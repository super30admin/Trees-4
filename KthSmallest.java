// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach:- Perform inorder traversal and find the kth value.

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
        
        //Iterative approach
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null) {

            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            
            k--;
            if(k == 0) {
                return root.val;
            }

            root = root.right;
        }

        return root.val;
    }
}