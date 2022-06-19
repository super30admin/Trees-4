/**
Time Complexity : O(N)
Space Complexity : O(D) depth of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left,p, q);
        else if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right,p, q);
        else
            return root;
    }
}