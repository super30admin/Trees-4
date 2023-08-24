// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
        //Call recursive function
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        //base
        if(root == null) return null;

        //Logic
        if(root == p || root == q) return root;
        //recurse
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);

        //If we find the LCA, return LCA else return the node which we get from recursion
        if(left != null && right != null) return root;

        else if(left != null) return left;

        else if(right != null) return right;

        return null;
    }
}