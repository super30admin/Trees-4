// Time Complexity : O(log(n)) --> where n is number of elements in the tree
// Space Complexity : O(h) --> where h is the height of tree
// Did this code successfully run on Leetcode (235):
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Recursive Solution
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // logic
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}