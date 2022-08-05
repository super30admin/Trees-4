// Time Complexity : O (N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

//Problem statement: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Problem2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            int parentVal = root.val;
            int pVal = p.val;
            int qVal = q.val;

            if (pVal > parentVal && qVal > parentVal) {
                return lowestCommonAncestor(root.right, p, q);
            } else if (pVal < parentVal && qVal < parentVal) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return root;
            }
        }
}