// In this problem, we are trying to perform indorder traversal which will give us sorted order and keeping a count variable equal
// to k, everytime we pop a value, we decrement the count and check if the count is 0, then save the value of root in answer and 
// return

// Time Complexity : O(n)
// Space Complexity : O(H) recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Recursive solution
class Solution {
    // Declare
    int count;
    int answer;

    public int kthSmallest(TreeNode root, int k) {
        // Base case
        if (root == null) {
            return -1;
        }
        // Declare
        count = k;
        answer = -1;
        // Recursive call
        inorder(root);
        // Return ans
        return answer;
    }

    private void inorder(TreeNode root) {
        // Base case
        if (root == null || answer != -1) {
            return;
        }
        // Go all the way to left to get the smallest value
        inorder(root.left);
        // Decrement count
        count--;
        // If count is 0 then save root.val in ans and return
        if (count == 0) {
            answer = root.val;
            return;
        }
        // Else make the right recursive call
        inorder(root.right);
    }
}

// Iterative solution
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return 3414324;
    }
}