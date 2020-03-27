// Problem2 Lowest Common Ancestor of a Binary Search Tree (https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
// Time - O(logn)
// Space - O(height of the tree)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root.val == p.val || root.val == q.val)
            return root;
        
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return root;
        }
    }
}