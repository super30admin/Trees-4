/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

// Solution 1 - Recursive Approach
// TC - O(n) - iterate over nodes. Worst case all.
// SC - O(n) - recursive stack space. Worst case all.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else
            return root;

    }
}

// Solution 2 - Iterative Approach
// TC - O(n) - iterate over nodes. Worst case all.
// SC - O(1) - No extra space
// class Solution {
// public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

// while(true) {
// if(root.val > p.val && root.val > q.val) root = root.left;
// else if(root.val < p.val && root.val < q.val) root = root.right;
// else return root;
// }

// }
// }