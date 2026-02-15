/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// Solution 1- DFS with path and backtracking
// TC - O(n) iterate over all the elements
// SC - O(n) two array lists to track the LCA.
// class Solution {
// public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
// List<TreeNode> qList = new ArrayList<>();
// List<TreeNode> pList = new ArrayList<>();
// helper(root, p, q, qList, pList, new ArrayList<>());
// for (int i = 0; i < qList.size(); i++) {
// if (qList.get(i).val != pList.get(i).val) {
// return qList.get(i - 1);
// }
// }
// return root;
// }

// private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode>
// qList, List<TreeNode> pList,
// List<TreeNode> path) {
// // Base
// if (root == null)
// return;

// // Logic
// path.add(root);

// if (root == p) {
// pList.addAll(path);
// pList.add(root);
// }
// if (root == q) {
// qList.addAll(path);
// qList.add(root);
// }
// // Recurse
// helper(root.left, p, q, qList, pList, path);
// helper(root.right, p, q, qList, pList, path);

// // Backtrack
// path.remove(path.size() - 1);
// }
// }

// Solution 2 : recursive without maintining path
// TC - O(n) - worst case iterate over all the nodes
// Sc - O(1) - No extra space
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null)
            return null;
        else if (left != null && right == null)
            return left;
        else if (left == null && right != null)
            return right;
        else
            return root;

    }
}