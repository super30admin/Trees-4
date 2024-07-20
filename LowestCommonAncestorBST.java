/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/***
 TC - O(h)
 SC - O(h)
 */

class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        //If both nodes belong to left subtree
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

            //If both belong to right subtree
        else if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

            //Both belong to different subtree
        else {
            return root;
        }

    }
}