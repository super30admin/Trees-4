// Time Complexity : O(n) brute force, O(n) optimal solution.
// Space Complexity : O(h) but possibly loss of precision because of integer value.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

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
        if(root == null || root == p || root == q){
            return root;
        }
        // System.out.println(root.val);
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null){
            return null;
        }else if(left != null && right == null){
            return left;
        }else if (left == null && right != null){
            return right;
        }else{
            return root;
        }
    }
}