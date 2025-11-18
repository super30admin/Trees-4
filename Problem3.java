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

        if (root == null || p == null || q == null) return null;

        findLCA(root, p, q);

        return answer;
    }

    private int findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (answer != null) return -1;

        if (root == null) return 0;

        int currVal = p.val == root.val || q.val == root.val ? 1 : 0;
        int totalSum = findLCA(root.left, p, q) + findLCA(root.right, p, q) + currVal;
        
        if (totalSum >= 2) {
            answer = root;
            return -1;
        }

        if (root.val == p.val || root.val == q.val) return 1;

        else return totalSum;

    }
}
