// Time Complexity : O(n) Traversing each node once
// Space Complexity : O(n) Recursive Stack

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
        
        // Empty tree
        if (root == null){
            return root;
        }
        
        // If one of the nodes is root it will be the LCA
        if (root.val == p.val || root.val == q.val){
            return root;
        }
        
        
        TreeNode leftResult = lowestCommonAncestor(root.left , p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right , p, q);
        
        if (leftResult != null  && rightResult != null){
            return root;
        }
        
        else if (leftResult != null){
            return leftResult;
        }
        
        else{
            return rightResult;
        }
        
    }
}