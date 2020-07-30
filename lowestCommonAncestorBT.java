// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    TreeNode result = null;
    
    private boolean recurse(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return false;
        
        int mid = (root==p || root==q)?1:0;
        int left = recurse(root.left,p,q)?1:0;
        int right = recurse(root.right,p,q)?1:0;
        
        if(mid+left+right>=2)
            result = root;
        
        return (mid+left+right>0);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        
        recurse(root,p,q);
        return result;
        
    }
}