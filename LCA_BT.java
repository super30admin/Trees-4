//Time Complexity: O(n)
//Space Complexity: O(1)
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
        if(root==null || root==p || root==q)
            return root;
        //logic
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        if(left==null && right==null)
            return null;
        else if(left!=null && right==null)
            return left;
        else if( left ==null && right!=null)
            return right;
        else
            return root;
    }
}
