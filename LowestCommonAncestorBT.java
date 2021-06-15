// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) we are iterating through all the nodes.
//Space Complexity: O(1) since we are not taking any extra space 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        //Base Case
        
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;            
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root; // Since I have my p and q values on left and right, I am the least common ancestor
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }
}