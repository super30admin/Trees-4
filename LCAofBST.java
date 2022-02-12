/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity : Add : O(log N),
// Space Complexity : O(log N),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(p.val < root.val && q.val < root.val) // T.C - O(log N)  S.C- O(log N)
                root = root.left;
            else if(p.val > root.val && q.val > root.val)
                root = root.right;
            else 
                return root;
        }
    }
}
