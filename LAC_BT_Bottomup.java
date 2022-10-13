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
    //tc - o(n)
    //sc - o(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     return helper(root, p ,q);
     
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q)
    {
        //base case
        if(root == null || root == p || root == q)
        return root;
        //logic
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p , q);
        
        if(left == null && right == null)
        return null;
        else if(left != null && right == null)
        return left;
        else if(left == null && right != null)
        return right;
        else
        return root;

  }
}