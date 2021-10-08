/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class LCA_BST {

    // TC:O(H) SC:O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (p.val > root.val && q.val > root.val)
                root = root.right;
            else if (p.val < root.val && q.val < root.val)
                root = root.left;
            else
                return root;
        }

    }
}