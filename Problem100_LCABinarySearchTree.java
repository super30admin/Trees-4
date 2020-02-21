//Time Complexity : O(n)
//Space Complexity: No space needed

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
        //edge case
        if(root==null) 
            return null;
        //if p and q are less than root
        //call lowestCommonAncestor function again on left since its a BST
        //all nodes on the left subtree and smaller than that of root
        if(p.val < root.val && q.val < root.val) 
        {
            return lowestCommonAncestor(root.left,p,q);
        } 
        //if p and q are more than root
        //call lowestCommonAncestor function again on right since its a BST
        //all nodes on the right subtree and greater than that of root
        else if(p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }
        else
        {
            return root;
        }
    }
}