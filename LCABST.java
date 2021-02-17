/**
Time Complexity : O(logN)
Space Complexity : O(logN)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


**/
class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if( root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
            
        return root;
    }
}