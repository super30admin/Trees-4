// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int count = 0;
    int result = 0;
    
    public int kthSmallest(TreeNode root, int k) 
    {
        helper(root, k);
        return result;
    }
    
    public void helper(TreeNode root, int k)
    {
        if(root == null)
        {
            return;
        }
        helper(root.left, k);
        count++;
        
        if(count == k)
        {
           result = root.val;
            return;
        }
        helper(root.right, k);
        return;
    }
}

// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left, p , q);
        }
        
        if(p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right, p , q);
        }
        
        return root;
    }
}

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root == null)
        {
            return null;
        }
        
        if(root == p || root == q)
        {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) 
        {
            return root;
        }
        
        if(left != null) 
        {
            return left;
        }
        return right;
    }
}