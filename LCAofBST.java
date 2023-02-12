// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We traverse the binary tree and search for nodes p and q
// We traverse the left or right subtrees depending on the values of the node compared to p & q

class Solution {
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return;
        if(root.val>p.val && root.val>q.val)
            helper(root.left, p,q);
        else if(root.val<p.val && root.val < q.val)
            helper(root.right, p, q);
        else
                result = root;
    }
}