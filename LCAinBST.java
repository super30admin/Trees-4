// Time Complexity : O(h)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : For a node to be Lowest common ancestor of two input nodes p and q, it has be the deepest node in the tree
/// where p is on node's left sub tree and q is on node's right subtree. So use BST property and let's traverse tree while 
/// comparing it's value with p and q. If p.val < node.val <q.val or q.val<node.val<p.val then current node is lca, return it.
/// Else mode to the subtree of node that has p and q

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
        if(root == null){
            return root;
        }
        while(root!=null){
            if(root.val<p.val && root.val<q.val){
                root = root.right;
            }
            else if(root.val>p.val && root.val>q.val){
                root = root.left;
            }
            else{
                return root;
            }
        }
        return null;
    }
}