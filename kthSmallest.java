// Time Complexity :O(n) n is the number of nodes
// Space Complexity :O(h) height of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int count;int result;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        count = k;
        helper(root);
        return result;
    }
    
    private void helper(TreeNode root){
        //base case
        if(root == null) return;
        
        //logic
        helper(root.left);
        count--;
        if(count == 0){
            result = root.val;
        }
        else{
            helper(root.right);
        }
    }
}