/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
Leet Code Submitted : Yes
Space Complexity : O(1)
Time Complexity : O(Number of nodes in Tree)

The idea is to use Binary Search Tree property where root will always be greater than left part of the tree and root will be less than right part of tree. Then we can compare p and q values with root to see on which part of the tree we need to traverse to determine lowest common ancestor 
**/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val)
            return root;
        if(root != null && p.val <= root.val && q.val <= root.val){
            //left side of the tree
            return lowestCommonAncestor(root.left,p,q);
        }else if(root != null && p.val >= root.val && q.val >= root.val){
            //right side of the tree
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
}
