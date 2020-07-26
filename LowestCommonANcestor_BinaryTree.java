/**
 * Algo: Call on both left and right nodes and whnever both are not null return that node val else return whichever is not null
 * Time: O(n) all ele in the tree
 * Space: O(log n) height of the recursive stack
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
        if(root == null || root.val == p.val || root.val == q.val) return root;


        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right =lowestCommonAncestor(root.right, p, q);

        if((left)!=null && (right)!=null)return root;
        else if(left != null) return left;
        else if(right != null)return right;
        else return null;

    }
}