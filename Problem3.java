// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Time complexity : O(N)
// Space complexity : O(H)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        if(root == p || root == q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(right == null)
            return left;
        else if(left == null)
            return right;
        return root;
    }
}
