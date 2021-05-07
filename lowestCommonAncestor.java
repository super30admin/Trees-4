// Runtime complexity - O(n)
// spaceTime complexity - O(H)

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
        return getlcs(root,p,q);
    }
    public TreeNode getlcs(TreeNode root,TreeNode p, TreeNode q)
    {
        if(root==null || root==p || root==q)
            return root;
        TreeNode left=getlcs(root.left,p,q);
        TreeNode right=getlcs(root.right,p,q);
        if(left!=null && right!=null)
            return root;
        else if(right!=null)
            return right;
        else if(left!=null)
            return left;
        return null;
    }
}
