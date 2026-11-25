/**
 * Time Complexity:  O(n)  where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree
 */


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

        if(p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        else if(root.val >= p.val && root.val <= q.val){
            return root;
        }else if(root.val < p.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return lowestCommonAncestor(root.left, p, q);
        }


    }
}