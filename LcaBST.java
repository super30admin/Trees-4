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
            return root;
        }
        // Recursive
        // return dfs(root, p, q);

        //Iterative
        while(true) {
            if(root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if(root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        } else if(root.val > p.val && root.val > q.val) {
            return dfs(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val) {
            return dfs(root.right, p, q);
        }
        return root;
    }
}
