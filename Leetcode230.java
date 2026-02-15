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
// Solution 1 - DFS (inorder traversal) with path
// TC - O(n) iterate over all the nodes
// SC - O(n) recursive stack space and array list space. Worst case all.
// class Solution {
// public int kthSmallest(TreeNode root, int k) {
// List<TreeNode> path = new ArrayList<>();
// helper(root, path);
// return path.get(k-1).val;

// }

// private void helper(TreeNode root, List<TreeNode> path) {
// // Base
// if(root == null) return;

// // Logic
// //Left
// helper(root.left, path);

// // Root
// path.add(root);

// // Right
// helper(root.right, path);

// }
// }

// Solution 2 - Inorder Traversal with Left Count
// TC - O(n)
// SC - O(n)
class Solution {
    int res;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        helper(root);
        return res;

    }

    private void helper(TreeNode root) {
        if (root == null)
            return;

        helper(root.left);
        count--;
        if (count == 0)
            res = root.val;
        helper(root.right);
    }
}