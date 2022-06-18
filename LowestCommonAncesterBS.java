// Time Complexity : O(N) N = number of nodes
// Space Complexity : O(H) recursion, H = height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class LowestCommonAncesterBS {
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
            if(root == null || root == p || root == q)
                return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if(left != null && right != null)
                return root;
            else if (left == null && right != null)
                return right;
            else if(left!= null && right == null)
                return left;
            else
                return null;
        }
    }
}
