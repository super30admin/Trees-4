// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) 
    {
        helper(root, k);
        return result;
    }

    private void helper(TreeNode root, int k) 
    {
        if (root == null) 
        {
            return;
        }

        helper(root.left, k);

        count++;
        if (count == k) 
        {
            result = root.val;
            return; 
        }

        helper(root.right, k);
    }
}
