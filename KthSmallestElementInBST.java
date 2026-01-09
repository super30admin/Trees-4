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
    // Approach: Inorder (Iterative) and Stack. Stop after evaluating k elements from the stack.
    // TC: O(N); In worst case k = N
    // SC: O(h) for Stack; h = height of the tree
    public int kthSmallest(TreeNode root, int k) {
        // inorder
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop(); // removed least element from the 
            k --; // reduce the count
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}