// TC = O(h) -- h is the height of the tree best case h = logn
// SC = O(h) -- h is the height of the tree
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
        // Recursive Solution
        // if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        // if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        // return root;

        // Iterative Solution
        while(true){
        if(root.val>p.val && root.val>q.val) root = root.left;
        else if(root.val<p.val && root.val<q.val) root = root.right;
        else return root;
        }
    }
}