// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach: recursion

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==root || q==root) return root;

        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);

        if(right==null) return left;
        if(left==null) return right;

        return root;
    }
}