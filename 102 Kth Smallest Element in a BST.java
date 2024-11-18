// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //aesha
    int count=0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result;
       
    }
    public void helper(TreeNode root, int k)
    {
         if(root == null) return;

        helper(root.left, k); 
        count ++;
        if(count == k)
        {
            this.result = root.val;
            return;
        }
        helper(root.right, k );
    }
}