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
    private int count = 0;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode top = new TreeNode();
        // stack.push(root);
        while (true) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        TreeNode node = stack.pop();
        if (--k == 0) {
            res = node.val;
            break;
        }
        root = node.right;
    }
    return res;
    }


//Time complexity : O(N+k) for a left skewed tree in worst case
//Space complexity : O(N) in worst case and avg case is O(logN)
