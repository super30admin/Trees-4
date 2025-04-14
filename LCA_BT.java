// In this problem, we are trying to use backtracking, keep a path list while traversing the nodes, if found p adding the path to 
// the result pathP, and then backtrack and move forward, until found both p and q.

// Time Complexity : O(n+H) - no. of nodes plus for loop traversal of pathP and pathQ
// Space Complexity : O(H) - height of the tree - recursive stack space, pathP and pathQ space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
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
    // pathp and pathq
    List<TreeNode> pathP;
    List<TreeNode> pathQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base
        if (root == null) {
            return root;
        }
        // Initialize both list
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        // DFS call
        dfs(root, p, q, new ArrayList<>());
        // After the call is completed, we will have path to p and q stored in pathp and
        // pathq, so just iterate and check wherever mismatch found, our ans lies one
        // prior to it
        for (int i = 0; i < pathP.size(); i++) {
            if (pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i - 1);
            }
        }
        return null;
    }

    // (pathP.size()>0 && pathQ.size()>0))
    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // Base, Also checking if the pathP and pathQ is already discovered, we dont
        // need to go further
        if (root == null || (pathP.size() > 0 && pathQ.size() > 0)) {
            return;
        }
        // Backtracking template:
        // Action - Add the root to the path
        path.add(root);
        // Check if the current root value is equal to p or q, if so add the current
        // path to our pathp or pathq
        if (root == p) {
            pathP = new ArrayList<>(path);
            // Also, add one time p, so that if only one element in pathP list, we will find
            // mismatch when we go to this extra added p
            pathP.add(p);
        }
        if (root == q) {
            pathQ = new ArrayList<>(path);
            // Also, add one time q, so that if only one element in pathP list, we will find
            // mismatch when we go to this extra added q
            pathQ.add(q);
        }
        // Recurse
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        // Backtrack
        path.remove(path.size() - 1);
    }
}

// Bottom-up recursion approach:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity : O(n) - no. of nodes
// Space Complexity : O(H) - height of the tree - recursive stack space, pathP
// and pathQ space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base
        if (root == null || root == p || root == q) {
            return root;
        }
        // left and right recursive calls
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // Check if left is null and right is null, it will return null to its parent
        if (left == null && right == null) {
            return null;
        }
        // Else it will return whatever is not null
        else if (left == null && right != null) {
            return right;
        } else if (right == null && left != null) {
            return left;
        }
        // Else it will return root if both have some values in it
        else {
            return root;
        }
    }
}