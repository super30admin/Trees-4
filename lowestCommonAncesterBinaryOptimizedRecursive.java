/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time: O(n) in worst case
// Space: O(1) 
// Idea here is to recursively find p and q if neither is found we propagate leaf value(null if not found) to parent's left answer and null for parent's right answer.
// if any is found return it to parent's left or right as per position and continue search for other one in rest of the tree left.
// finally atthe root wehave either both found,or left found or right found,which will be our result.
class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p ||root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null && right==null) return null;
        else if(left!=null && right==null) return left;
        else if(left==null && right!=null) return right;
        else return root ;
    }
}