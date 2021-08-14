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
        
        if(root == null) {
            return 0;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int count = 0;
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.add(root);
                root = root.left;
            }
            
            TreeNode curr = stack.pop();
            count++;
            
            if(count == k) {
                return curr.val;
            }
            
            root = curr.right;
        }
        return -1;
    }
}

//Time : O(n)
//Space : O(h)