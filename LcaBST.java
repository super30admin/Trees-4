/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// This solution utilized the BST factor where we diverge the search to left if both p and q are less than root or right if p and q are greater than root. If both are not the cases, that means root is the LCA
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while(true) {
            if(p.val<root.val && q.val<root.val) {
                root = root.left;
            }
            else if(p.val>root.val && q.val>root.val) {
                root = root.right;
            }
            else return root;
            }
        }
}
