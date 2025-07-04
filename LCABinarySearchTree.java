// TC : O(h)
// SC : O(n)
// Runs on LeetCode: YES
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
    ArrayList<TreeNode> pPath;
    ArrayList<TreeNode> qPath;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q, new ArrayList<TreeNode>());

        // find commonality btwn pPath & qPath

        TreeNode prev = null;
        for (int i = 0; i < pPath.size(); i++) {
            if (qPath.get(i) != pPath.get(i)) {
                return qPath.get(i - 1);
            }
        }
        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base
        if (root == null) {
            return;
        }
        if(pPath != null && qPath != null){
            return;
        }
        // action
        path.add(root);

        if (root.val == q.val) {
            qPath = new ArrayList<TreeNode>(path);
            qPath.add(root);
        }
        if (root.val == p.val) {
            pPath = new ArrayList<TreeNode>(path);
            pPath.add(root);
        }

        // recurse
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);
        // backtrack
        path.remove(path.size() - 1);
    }
}