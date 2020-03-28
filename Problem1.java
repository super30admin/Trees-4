// Time Complexity : O(k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

// Your code here along with comments explaining your approach: Used a variable to check the count. Inorder traversal and then decremented k

class Solution {
    int result;
    int K;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        K = k;
        traverse(root);
        return result;
    }

    public void traverse(TreeNode node) {

        if (node == null) {
            return;
        }

        traverse(node.left);

        K--;
        if (K == 0) {
            result = node.val;
            return;
        }

        traverse(node.right);
    }
}