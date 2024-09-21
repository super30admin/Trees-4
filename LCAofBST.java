/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// TC: O(h) h is the height of the tree
// SC: O(h)
class LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        if(p.val<root.val && q.val<root.val) {
            // both nodes p and q are on left of root
            return lowestCommonAncestor(root.left,p,q);
        } else if(p.val>root.val && q.val>root.val) {
            // both nodes p and q are on left of root
            return lowestCommonAncestor(root.right,p,q);
        } else {
            // one node is on left and another is on right
            return root;
        }
    }
}