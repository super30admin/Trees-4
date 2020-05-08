// 236.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//time - O(n)
//space - O(h)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if(root == null)
        {
            return null;
        }
        if(root.val == p.val || root.val == q.val)
        {
            return root;
        }
        //logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null)
        {
            return null;
        }
        if(left != null && right != null)
        {
            return root;
        }
        if(left != null)
        {
            return left;
        }
        return right;
    }
}

// lca(3, 2, 0) -> lca(5, 2, 0) -> lca(6, 2, 0) -> lca(null, 2, 0)
//                                              <- null
//                                              -> lca(null, 2, 0)
//                                              <- null
//                              <- null
//                              -> lca(2, 2, 0)
//                              <- 2
//              -> lca(1, 2, 0) -> lca(0, 2, 0)
//                              <- 0
//              <- 3
