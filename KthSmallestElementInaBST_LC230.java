// Time Complexity : O(n + k log n) O(n) to traverse all n nodes.
//O(log n) insertion into heap (in worst case, n elements in heap).
//O(k log n) to poll k elements.
// Space Complexity : O(n) n = PriorityQueue length
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES

import java.util.PriorityQueue;

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
class KthSmallestElementInaBST_LC230 {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        handlePQ(root, k, pq);

        int ans = 0;
        while (k > 0) {
            ans = pq.poll();
            k--;
        }

        return ans;
    }

    private void handlePQ(TreeNode root, int k, PriorityQueue<Integer> pq) {
        if (root == null) return;

        pq.offer(root.val);

        handlePQ(root.left, k, pq);
        handlePQ(root.right, k, pq);
    }
}