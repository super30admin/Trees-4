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
    //Time O(N)
    //Space O(H)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root)
        {
            return root;
        }
        TreeNode Left = lowestCommonAncestor(root.left , p , q);
        TreeNode Right = lowestCommonAncestor(root.right , p , q);
        if(Left != null && Right != null) return root;
        else if(Left != null) return Left;
        else if(Right != null) return Right;
        else return null;
    }
}