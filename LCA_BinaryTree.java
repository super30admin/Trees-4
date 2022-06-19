/**
Time Complexity : O(N)
Space Complexity : O(D) depth of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root.val == p.val || root.val == q.val)
            return root;
        
        TreeNode left = null;
        TreeNode right = null;
        
        if(root.left!= null)
            left = lowestCommonAncestor(root.left, p, q);
        
        if(root.right != null)
            right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right!=null)
            return root;
        else if(left != null)
            return left;
        else
            return right;
    }
}