// Time complexity : O(h) // worst case : h can find at max n nodes: Skew BST 
// Space Complexity : O(n) : Stack

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
        
        // p and q doesnot exist
        if (root == null){
            return null;
        }
        
        // BST : root < p and q then both p and q are in right sub tree
        if ( root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        
        // BST : root > p and q then both p and q are in left sub tree
        else if ( p.val < root.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        
        // root will be the LCA if one node is in left and other is in right
        else {
            return root;
        }
    }
}