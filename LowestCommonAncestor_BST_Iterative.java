// Time Complexity : O(log(n)) --> where n is number of elements in the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (235): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Iterative Solution
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val ) root = root.right;
            else return root;
        }
        return null;
    }
}