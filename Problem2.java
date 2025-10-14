/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // 235. Lowest Common Ancestor of a Binary Search Tree
/*
if both val are smaller go to left, if both val are bigger go to right else we have found the common ancestor
TC: O(n) SC: O(h)
Ran on leetcode: Yes
*/
class Solution {
    private TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q){
        if(root.val > p.val && root.val > q.val){ // check left if both the val are smaller
            helper(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val){ // check right if both the val are bigger
            helper(root.right, p, q);
        } else { // if both the value are not greater and smaller we have found the common ancestor
            result = root;
        }
    }
}