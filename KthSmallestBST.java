// Time Complexity :  O(N) - The k sth smallest can be second last element
// Space Complexity : O(N) - recursive stack space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    int ans = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        count--;
        if(count == 0) ans = root.val; 
        dfs(root.right);
        
    }
}