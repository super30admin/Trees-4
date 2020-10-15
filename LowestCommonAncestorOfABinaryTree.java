// Time Complexity : O(N) N is the number of TreeNodes in the given binary tree as worst case would reach N
// Space Complexity : O(N) N is the number of nodes in the binary tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        
        if(root == null)    return null;
        
        if(p.val == root.val || q.val == root.val)  return root;
        
        //search left node of every node whether the value of p or q exists.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        
        //search right node of every node in the tree to check whether value of p or q exists.
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        
        if(left != null && right != null)   return root;  //LCA found i.e. we have found our left node which contains either of p and q and right node which contains the remaining of p and q.
        else if(left != null)   return left;  //we have found one out of p and q nodes.
        else return right;  //we have found one out of p and q nodes.
        
    }
}
