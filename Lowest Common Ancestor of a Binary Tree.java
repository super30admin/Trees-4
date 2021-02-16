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
        //if you hit a null, p, or q then return root;
        if(root == null || root == p || root == q) return root;
        //logic
        //set a left and then call recursion on left
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //st,pop will happen when null or p or q is hit
        //set a right and then call recursion on right
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //check if both left and right don't equal null return that root
        if(left != null && right != null) return root;
        //if left doesn't equal null return left
        else if(left != null) return left;
        //if right doesn't equal null return right
        else if(right != null) return right;
        //if nothing occurs return null
        else return null;
    }
}