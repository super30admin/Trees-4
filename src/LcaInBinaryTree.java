// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
 * 
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
        //base- if root is one of the p, q or root is null
        if(root == null || p.val == root.val || q.val == root.val) return root;
        
        //logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //if p and q are found on each side of root,root is LCA
        if(left != null && right != null) return root;
        else if(left != null) return left; //one from p,q is found on left
        else if(right != null) return right; // one from p,q is found on right
        else return null; // none of p,q found on current roots right and left side
    }
}