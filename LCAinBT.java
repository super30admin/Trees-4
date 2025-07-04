// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Traverse through entire tree while keeping in track if we found p/q in left subtree and q/p in right subtree.
/// If yes then current node is LCA, else return the left or right subtree node which has p/q. If neither p or q was found return nulll
/// 

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
        return helper(root, p, q);
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root ==p || root== q){
            return root;
        }
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if(left==null && right==null){
            return null;
        }
        else if(left == null && right!=null){
            return right;
        }
        else if(left!=null && right == null){
            return left;
        }
        else{
            return root;
        }
    }
}