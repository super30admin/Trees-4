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
        
        if(p.val == root.val || q.val == root.val) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) {
            return root;
        } else if(left != null) {
            return left;
        } else {
            return right;
        }
    }
}

//Time : O(n), where n is the no. of nodes in worst case
//Space : O(h), height of tree which is the number of nodes in the stack at most at a particular time