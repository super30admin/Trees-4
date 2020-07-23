// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
    
        if(root == null || p.val == root.val || q.val == root.val)
            return root;
        
        //logic
        
        TreeNode left =lowestCommonAncestor(root.left,p,q);
        
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left!= null && right!=null)
            return root;
        else if(left != null)
            return left;
        else 
           return right; 
        
    }
}