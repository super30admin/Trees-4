// Time Complexity : O(n) n = number of nodes
// Space Complexity : O(h) h = height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//using DFS - bottom up recursion

//rather than maintaining paths, we return found nodes to parent when recursion returns to parent

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //base
        if(root == null || root.val == p.val || root.val == q.val)
            return root;

        //logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null)
            return null;
        else if(left != null && right == null)
            return left;
        else if(left == null && right != null)
            return right;
        else
            return root;
    }


}
