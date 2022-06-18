// Time Complexity : O(N) N = number of nodes
// Space Complexity : O(N) stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class LowestCommonAncestorfBST {
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
            TreeNode curr = root;

            while(curr != null) {
                //if p & q > root
                if(p.val > curr.val && q.val > curr.val)
                    curr = curr.right;
                else if(p.val < curr.val && q.val < curr.val)
                    curr = curr.left;
                else
                    return curr;

            }
            return null;
        }
    }
}
