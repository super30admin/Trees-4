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
        
        if(root == null) {
            return null;
        }
        
        TreeNode node = root;
        
        while(node != null) {
            if(p.val > node.val && q.val > node.val) {
                node = node.right;
            } else if(p.val < node.val && q.val < node.val) {
                node = node.left;
            } else {
                return node;
            }
        }
        return new TreeNode(-1);
    }
}

//Time : O(N), where N is the number of nodes in the BST
//Space : O(1)