//235. Lowest Common Ancestor in a Binary Search Tree - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
//Time Complexity: O(h)
//Space Complexity: O(h)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //edge case
        if(root==null)
            return null;

        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left,p,q); //recurse through left subtree
        else if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q); //recurse through right subtree
        else return root; //return root if p and q can be left and right subtree
    }
}