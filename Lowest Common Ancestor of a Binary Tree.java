/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //TC = O(n)
//SC = O(n)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //base condition
        if(root == null || root == p || root == q) return root;

        //recursion
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) return null;
        else if (left != null && right == null) return left;
        else if(left == null && right !=null) return right;
        else return root;
    }
}
