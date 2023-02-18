// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N

// Your code here along with comments explaining your approach

class Solution {
    int k;
    int curr = 0;
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (curr == k)
            return;

        if (root.left != null)
            dfs(root.left);
        curr++;
        if (curr == k)
            ans = root.val;
        else if (root.right != null)
            dfs(root.right);

    }
}