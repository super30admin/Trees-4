/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // This solution does a recursion on the given root on both left and right. At any point if both the left and right return nothing., that means its not LCA> If one of them or both returns a node, that means its an LCA. 
 // Also base condition is if any val equals the node that we are exploring, then we dont have to explore sub tree and will return the node.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        if(root==p || root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left==null && right==null) return null;
        if(left!=null && right==null) return left;
        if(left==null && right!=null) return right;

        return root;
    }
}
