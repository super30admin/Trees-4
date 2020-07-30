// Time Complexity : O(k) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    //Stack<Integer> st = new Stack<>();
    int count = 0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        kthSmallest(root.left,k);
        count++;
        if(count==k)
            result = root.val;
        if(result > -1)
            return result;
        kthSmallest(root.right,k);
        
        return result;
    }
}