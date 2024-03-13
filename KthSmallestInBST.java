// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Inorder traversal with a stack to return the kth
// smallest value

import java.util.Stack;

public class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        TreeNode top = null;
        // smallest element on top of stack;
        while (!stack.isEmpty()) {
            top = stack.pop();
            k--;
            if (k == 0) {
                return top.val;
            }
            TreeNode node = top.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        return Integer.MAX_VALUE;
    }
}
