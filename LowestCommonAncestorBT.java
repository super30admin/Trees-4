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
        //base case
        if(root == null){
            return root;
        }
        
        //if either value is root then return root
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        
        //check if you have nodes on left and right sub trees
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // if values lie on both sub trees return root
        //else if both values lies only on left return value from left sub tree
        //else return value from right sub tree.
        if(left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else{
            return right;
        }
    }
}
//Time complexity: O(n) n -> number of nodes
//Space Coomplexity: O(h) h -> height if the tree