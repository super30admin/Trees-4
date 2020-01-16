// Time Complexity - O(n)
// Space Complexity - O(1) if recursive stack is not considered as extra space
// This solution worked on LeetCode

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Base Case
        if(root == null || p == root || q == root)
            return root;
        //Logic
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else if(right != null)
            return right;
        else return null;
    }
}
