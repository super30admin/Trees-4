/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time: O(log(n)
// Space: O(1)
// Idea is if at any point of time if p's value is less than root's val and q's value is greater than
// root's value, or vice versa then root is the only option for common ancester
// else if both are less, we keep going left, if both are more, we keep going right.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(p.val<root.val && q.val<root.val) root = root.left;
            else if(p.val>root.val && q.val>root.val) root = root.right;
            else return root;
        }
    }
}