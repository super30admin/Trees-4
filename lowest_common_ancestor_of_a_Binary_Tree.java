// Time Complexity :O(n), where n is the size of the tree
// Space Complexity :O(h), where h is the height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain English
//1. Start DFS from the root and keep looking if you find p OR q OR null (in the left OR right), if yes, return that to the parent
//2. If a root's (left and right become not null) meaning you found the p and q, so that root is the LCA
//3. Else keep returning what you find to the parent, and that is the LCA (in the end if only 1 of p OR q found that is the LCA, 
        // because the other lies below it(that is the other(not found) is a child of the node (found)))

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        //if root becomes null OR p OR q return root
        if(root == null || root == p || root ==q) return root;
        
        //logic
        //find the left 
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //find the right
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //if root's left and right become not null that means you found p and q at that node, so that root is LCA
        //Else which ever node(p OR q OR null) found return that to the root's parent
        if(left != null && right != null) return root;
        else if(right != null) return right;
        else if(left != null) return left;
        else return null;
    }
}