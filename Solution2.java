// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* 
 * I perform DFS on the tree and check if root.val is greater than both p.val and q.val. If so , I recursively perform dfs on left child
 * of root. Similarly If root.val is less than both p.val and q.val, I recursively perform dfs on the right child. If root.val >= p.val
 * and root.val<=q.val I return root as it's the ancestor.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return check(root,p,q);
    }
    
    public TreeNode check(TreeNode root, TreeNode p, TreeNode q)
    {
        
        if(root.val>p.val && root.val >q.val)
        {
            return check(root.left,p,q);
        }
        else if(root.val<p.val && root.val<q.val)
        {
            return check(root.right,p,q);
        }
        return root;
    }
}