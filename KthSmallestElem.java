// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

// Time Complexity: O(n)
// Space Complexity: O(n)

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
    int cnt;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        this.cnt = k;
        this.result = -1;
        helper(root, k);
        return result;
    }

    private void helper(TreeNode root, int k) {
        //base
        if(root == null) return;

        //logic
        helper(root.left, k);

        cnt--;
        if(cnt == 0) {
            result = root.val;
            return;
        }

        helper(root.right, k);
    }
}