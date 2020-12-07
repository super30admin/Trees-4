// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class SolutionOne {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null)
            return null;

        if(p.val<root.val && q.val<root.val)
        {
            return lowestCommonAncestor(root.left,  p,  q);
        }
        else if(p.val>root.val && q.val>root.val)
        {
            return lowestCommonAncestor(root.right,  p,  q);
        }
        else
            return root;

    }
}