import java.util.Stack;

//Time Complexity: O(n)
//Space Complexity: O(h)

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
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // Iterative Solution
        if (root == null)
            return -1;
        int count = k;
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || root != null) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            count--;
            if (count == 0) {
                return root.val;
            }
            root = root.right;

        }

        return -1;

    }
}