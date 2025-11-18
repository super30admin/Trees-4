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
    TreeNode answer;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        answer = null;

        if (root == null || p == null || q == null) return answer;

        findLCA(root, p, q);

        return answer;
    }

    private void findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (answer != null) return;
        if ((root.val == p.val || root.val == q.val) || (root.val>p.val && root.val<q.val) || (root.val>q.val && root.val<p.val)) answer = root;

        if (p.val < root.val && q.val < root.val) {
            findLCA(root.left, p , q);
        }

        if (p.val > root.val && q.val > root.val) {
            findLCA(root.right, p , q);
        }

    }
}
