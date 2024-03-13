// Time Complexity : O(n)
// Space Complexity : O(k) [Height of the BST]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


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
    List<Integer> listNode;
    int count;
    int val;

    public int kthSmallest(TreeNode root, int k) {
        // return helperBruteForce(root, k);
        count = k;
        helper(root);
        return val;
    }

    private void helper(TreeNode root) {
        val = -1;
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if(root.left != null) {
            inorder(root.left);
        }
        count--;
        if (count == 0) {
            val = root.val;
            return;
        }
        if(root.right != null) {
            inorder(root.right);
        }
    }

    private int helperBruteForce(TreeNode root, int k) {
        listNode = new ArrayList<>();
        helperInorder(root);
        return listNode.get(k - 1);
    }

    private void helperInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        helperInorder(root.left);
        listNode.add(root.val);
        helperInorder(root.right);
    }
}