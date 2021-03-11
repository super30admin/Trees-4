//time complexity-O(n)
//space complexity-O(depth)
//Ran on leetcode-Yes
//Solution with comments-
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
       
        if(root==p || root==q || root == null)
            return root;
                
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if (left!=null && right!=null)
        System.out.println(left.val+" "+right.val);
        if(left!=null && right !=null)
            return root;
        else if( right!=null )
            return right;
        else
            return left;
        
    }
}