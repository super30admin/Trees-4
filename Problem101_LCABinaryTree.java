//Time Complexity : O(n)
//Space Complexity: No extra space used

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
        if (root == null || root == p || root == q)
            //since a node can be a descendant of itself
            return root;
        
        // search p and q from left subtree and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
    //case1
        if(left == null && right == null)
            return null;
    //case2
        else if (left != null && right != null)
            //is not a leaf node
            //we found both p and q, so root is the lowest ancestor
            return root;
    //case3
        else if(left != null)
            //if only left exists
            return left;
    //case4
        else if(right != null)
            //if only right exists
            return right;            
        else
            return null;
    }

}