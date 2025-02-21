/*
 * Time complexity: O(n)
 * Space complexity: O(h)
 * Leetcode: Yes
 */
class Solution {
    int count = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        //base
        if (root == null) {
            return 0;
        }

        //logic
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        //base
        if (root == null) {
            return;
        }

        //logic
        dfs(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }
}