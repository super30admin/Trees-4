// Time Complexity : O(N)- worst case we need to traverse every node
// Space Complexity : O(N) - Internal stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
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
         int parentVal = root.val;

        int pVal = p.val;

        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else {
            return root;
        }
    }
}

// Your code here along with comments explaining your approach
