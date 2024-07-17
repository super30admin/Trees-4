// Time Complexity : O(h)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Iterative Search: Start from the root and traverse the tree.
//Left Subtree: If both p and q are less than the current node's value, move to the left child.
//Right Subtree: If both p and q are greater than the current node's value, move to the right child.
//LCA Found: If one of the nodes is on one side and the other node is on the other side, or if the current node is equal to one of the nodes, then the current node is the LCA.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// iterative method

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        while(true){
            if( root.val>p.val && root.val > q.val){
                root = root.left;
            }
            else if( root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
    }
}
