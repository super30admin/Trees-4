// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        if(root.val==p.val || root.val==q.val)
            return root;
        
        if((root.val>p.val && root.val<q.val) || (root.val<p.val && root.val>q.val))
            return root;
        
        if(root.val<p.val && root.val<q.val)
           return lowestCommonAncestor(root.right,p,q);
        else
           return lowestCommonAncestor(root.left,p,q);
    }
}
