// Time Complexity : O(log(n))
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int count;
    private TreeNode result;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result.val;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        if (result == null)
            inorder(root.left);
        count--;
        if (count == 0) {
            result = root;
        }
        if (result == null)
            inorder(root.right);
    }
}