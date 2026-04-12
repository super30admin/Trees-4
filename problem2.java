
    /**
    Time Complexity : O(N)
    Explanation:
    We traverse the tree to find both paths → O(N)
    Then compare both paths → O(H)

    Space Complexity : O(H)
    Explanation:
    Path lists and recursion stack depend on tree height.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially made mistakes in storing paths correctly and handling
    edge cases when paths are of different lengths.
    Fixed it by:
        - Properly storing path copies
        - Comparing paths until mismatch
    */

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


    List<TreeNode> li1;
    List<TreeNode> li2;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        li1 = new ArrayList<>();
        li2 = new ArrayList<>();

        helper(root, new ArrayList<>(), p, q);

        int i = 0;

        // Compare both paths
        while (i < li1.size() && i < li2.size() && li1.get(i) == li2.get(i)) {
            i++;
        }

        // Last common node
        return li1.get(i - 1);
    }

    private void helper(TreeNode root, List<TreeNode> path, TreeNode p, TreeNode q) {

        if (root == null) return;

        path.add(root);

        // Store path for p
        if (root == p) {
            li1 = new ArrayList<>(path);
        }

        // Store path for q
        if (root == q) {
            li2 = new ArrayList<>(path);
        }

        helper(root.left, path, p, q);
        helper(root.right, path, p, q);

        // Backtrack
        path.remove(path.size() - 1);
    }
}