/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
Brute force solution would be store path from root to p and path from root to q in two auxiliary arrays.
- then traversing both the arrays simuteniously till their values matches. last matched value would be LCA
- if end of the array is reached then last seen node would be lca
- Time and space complexity would be O(n) as we need O(n) space for storing values in array

Optimized approach
- I would recursively find the LCA of nodes p and q.
- I would be findning the node which has one of the key present in the left subtree and other key present in the right subtree
if any such node is present then its the LCA. 
- if q lies in subtree rooted at p then p would LCA
- if p lies in subtree rooted at q then q would be LCA
- Time Complexity- O(n)
- Space Complexity- O(h)
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        
        if(root == p || root == q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right= lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null)
            return root;
        
        return left != null ? left : right;
    }
}
