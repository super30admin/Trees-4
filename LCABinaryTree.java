/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Time :O(n)
//Space: O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null||root==p||root==q)
            return root;

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null) //both nodes are found
            return  root;

        else if(left==null && right!=null)
            return right;

        else if(left!=null && right==null)
            return left;

        return null;  //none of the nodes is found

    }
}