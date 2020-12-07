// Time Complexity :O(n)
// Space Complexity : height of the stack
// Did this code successfully run on Leetcode :yes
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
class SolutionTwo {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //base
        if(root==null || root==p || root==q)
            return root;


        TreeNode left = lowestCommonAncestor(root.left,p,q);

        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null)
            return root;
        else if(right!=null)
            return right;
        else if(left!=null)
            return left;
        else
            return null;

    }

}