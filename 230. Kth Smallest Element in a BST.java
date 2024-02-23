// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        stack.add(root);

        while(stack != null){
            TreeNode item = stack.pop();
            // leaf node
            if(item.left == null && item.right == null){
                if(--k == 0) return item.val;
            } else {
                if(item.right != null) stack.add(item.right);
                stack.add(item);
                if(item.left != null) stack.add(item.left);
                item.left = null;
                item.right = null;
            }
        }

        return -1;
        
    }
}
