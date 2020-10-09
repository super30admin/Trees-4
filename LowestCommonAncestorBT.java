// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Recursion  - unsing postorder
class Solution {
    TreeNode res;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return root;
        helper(root, p, q);
        return res; 
    }
    
    // Postorder
    private boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return false;
        
        int left = helper(root.left, p, q) ? 1 : 0;
        int right = helper(root.right, p, q) ? 1: 0;
        
        int mid = (root ==p || root==q) ? 1: 0;
        if( left + right + mid >=2) {
            res = root;
        }  
        
        return (left + right  + mid) > 0;
    }
}
