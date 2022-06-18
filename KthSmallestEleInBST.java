// Time Complexity : O(N) N = number of nodes
// Space Complexity : O(N) stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class KthSmallestEleInBST {
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
        List<Integer> list;
        public int kthSmallest(TreeNode root, int k) {
            list = new ArrayList<>();
            dfs(root);
            return list.get(k-1);
        }

        private void dfs(TreeNode root) {
            //base
            if(root == null) return;
            //logic
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
    }
}
