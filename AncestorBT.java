Time Complexity: O(n)
Space Complexity: o(1)
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
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        return helper(root, p, q);

    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null) return null;
        else if(root.val == p.val) return root;
        else if(root.val == q.val) return root;
        
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if(left != null && right != null) return root;
        else if(left != null) return left;
        else if(right != null) return right;
        else return null;

    }
}