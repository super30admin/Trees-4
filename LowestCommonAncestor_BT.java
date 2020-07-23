// Time Complexity : O(n) --> where n is the number of elements in the tree
// Space Complexity : O(h) --> where h is the height of the tree
// Did this code successfully run on Leetcode (236): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || p.val == root.val || q.val == root.val) return root;
            
        // logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}