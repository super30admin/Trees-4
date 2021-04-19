// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        if(root == null)
            return null;
        if(root.val == p.val || root.val == q.val){
            return root;
        }
	//on either side
        if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val))
            return root;
        else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
            
        }
        else
            return lowestCommonAncestor(root.right, p, q);
    }
}