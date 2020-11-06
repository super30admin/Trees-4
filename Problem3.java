// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, 4ms
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// If any of the nodes return null and the other one return the node, then the node is the ancestor

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }
        
        if(root == p || root == q){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left != null && right != null){
            return root;
        }
        
        if(left == null && right == null){
            return null;
        }
    
        return left != null ? left: right;
        
    }
}