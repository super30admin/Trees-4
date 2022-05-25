/*
Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// TC: O(n)
// SC: O(h)
// Space efficient
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        } 
        return left == null ? right : left;
    }
}

// Not space efficient but useful for other questions
class Solution {
    List<TreeNode> ancestorsP = null;
    List<TreeNode> ancestorsQ = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancestorsP = new LinkedList<>();
        ancestorsQ = new LinkedList<>();
        findAncestors(root, p, ancestorsP);
        findAncestors(root, q, ancestorsQ);
        
        TreeNode ancestor = null;
        int i = 0;
        while (i < Math.min(ancestorsP.size(), ancestorsQ.size()) && ancestorsP.get(i) == ancestorsQ.get(i)) {
            ancestor = ancestorsP.get(i);
            ++i;
        }
        return ancestor;
    }
    
    private boolean findAncestors(TreeNode root, TreeNode n, List<TreeNode> ancestors) {
        if (root == null)
            return false;
        
        ancestors.add(root);
        if (root == n)
            return true;
        
        if (findAncestors(root.left, n, ancestors)) {
            return true;
        }
        
        if (findAncestors(root.right, n, ancestors)) {
            return true;
        }
        ancestors.remove(ancestors.size() - 1);
        return false;
    }
}