// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* create 2 golbal paths for p and q.
 * in the helper function, add the numbers to the path till we find p and q.
 * if there is another path, we also backtrack the existing path.
 * At the end we iterate through pathp and pathq and if they don't match we send the previous val as the LCA.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    List<TreeNode> pathP;
    List<TreeNode> pathQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();

        helper(root, p, q, new ArrayList<>());

        for (int i = 0; i < pathP.size(); i++) {
            if (pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i - 1);
            }
        }

        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base
        if (root == null)
            return;
        // logic

        // action
        path.add(root);
        if (root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if (root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }

        // recurse
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);

        // backtrack
        path.remove(path.size() - 1);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * check the left and right values after the recursive call to the root of left
 * and right.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null)
            return null;
        else if (left == null && right != null)
            return right;
        else if (left != null && right == null)
            return left;

        else
            return root;
    }

}