 //Time Complexity:- O(n), Space complexity:- O(h)
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
        
        //bottom up recursion
        if(root == null || root == p || root == q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //if both left and right are null then we did not find p and q
        if(left == null && right == null)
            return null;

        //if we find both p and q then return root because it is the LCA
        else if(left != null && right == null)
            return left;

        else if(right != null && left == null)
            return right;

        else
            //if we find only 1 of the left or right
            return root;
    }
}