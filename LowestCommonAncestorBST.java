// Time Complexity : O(log n) 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach: check whether the given nodes are either side of root, if so, return the root
// else traverse to that side of that tree.

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
        return helper(root,p,q);
    }
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root.val<=p.val && root.val >= q.val  || root.val<=q.val && root.val >= p.val)
            return root;
        else if(root.val<p.val && root.val<q.val)
            return helper(root.right,p,q);
        else 
            return helper(root.left,p,q);
    }
}