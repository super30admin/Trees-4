// Time Complexity : O(K)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    int kthValue;
    int cnt;
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        kthValue = -1;
        helper(root);
        return kthValue;
    }
    private void helper(TreeNode root) {
        if(root == null || cnt <=0) return;
        helper(root.left);
        if(cnt > 0) {
            kthValue = root.val;
            cnt--;
        }
        helper(root.right);
    }
}
