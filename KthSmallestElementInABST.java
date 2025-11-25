/*
Problem: Kth Smallest Element in a BST (LeetCode 230)
Approach: Recursive inorder traversal (left -> root -> right). In a BST, inorder yields values in ascending order.
We maintain a counter and an early-exit when we find the k-th element.
Time Complexity: O(H + k) on average (where H is tree height) — O(n) worst-case.
Space Complexity: O(H) recursion stack.
LeetCode: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
*/

public class KthSmallestElementInABST {

    private int count = 0;
    private Integer result;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;

    }

    private void inorder(TreeNode root, int k) {
        if (root == null || result != null) return;

        inorder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
        }
        inorder(root.right, k);
    }
}
