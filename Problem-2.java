// Time Complexity : O(log(n))
// Space Complexity : O(h)
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
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            //p is on one side and q is on other side
            //p == root or q == root
            return root;
        }
    }
}