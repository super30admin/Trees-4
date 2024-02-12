// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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

        if(root == null || root == p || root == q) return root;

        TreeNode lcaL = lowestCommonAncestor(root.left, p, q);
        TreeNode lcaR = lowestCommonAncestor(root.right, p, q);

        if(lcaL == null && lcaR == null) {
            return null;
        } else if(lcaL == null && lcaR != null){
            return lcaR;
        } else if(lcaR == null && lcaL != null){
            return lcaL;
        }
        
        return root;

    }
}
