/*
Problem: Kth Smallest Element in a BST (LeetCode 230)
Approach: Iterative inorder traversal using an explicit stack. Inorder traversal of BST yields sorted order; pop k-1 nodes then next is kth smallest.
Time Complexity: O(H + k) on average (H = tree height) — O(n) worst-case.
Space Complexity: O(H) for the stack.
LeetCode: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
*/

import java.util.Stack;

public class KthSmallestElementInABST2 {


    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;

            root = root.right;

        }
        return 9090;
    }


}
