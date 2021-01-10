// Time Complexity : O(logN)
// Space Complexity : O(logN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(p.val > q.val)
            return lowestCommonAncestor(root, q, p);
        
        if(root == null || root.val == p.val || root.val == q.val)
            return root;
        
        if(root.val >= p.val && root.val <= q.val)
            return root;
        
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        
        else 
            return lowestCommonAncestor(root.left, p, q);
        
        
    }
}