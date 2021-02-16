// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
        //base
        if(root == null) return null;
        //logic
        //if they are both smaller than root recursively call left side
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        //if they are both smaller than root recursively call right side
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        //then return 
        return root;
    }
}
