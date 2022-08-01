// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int l = 0;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        
        l = k;
        smallest(root);
        return res;
        
    }
    
    private int smallest(TreeNode root) {
        if(root == null)
            return -1;
        
        smallest(root.left);
        --l;
        //System.out.println(l + " -> "+root.val);
        if(l==0)
            res = root.val;
        smallest(root.right);
        
        return -1;
    }
}
