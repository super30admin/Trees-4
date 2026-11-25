/**
 * Time Complexity:  O(n)  where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> lca = new ArrayList<>();
        findLCA(root, p, q, lca);

        return lca.get(0);

    }

    boolean[] findLCA(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> lca) {
        boolean found = false;
        boolean[] leftRightFound = new boolean[2];
        boolean[] leftRightFoundLocal = new boolean[2];

        if (!found && node.left != null) {
            leftRightFoundLocal = findLCA(node.left, p, q, lca);
            leftRightFound[0] = leftRightFound[0] || leftRightFoundLocal[0];
            leftRightFound[1] = leftRightFound[1] || leftRightFoundLocal[1];

        }

        if (!found && node.right != null) {
            leftRightFoundLocal = findLCA(node.right, p, q, lca);
            leftRightFound[0] = leftRightFound[0] || leftRightFoundLocal[0];
            leftRightFound[1] = leftRightFound[1] || leftRightFoundLocal[1];
        }

        if (!leftRightFound[0] && p == node) {
            leftRightFound[0] = true;
        } else if (!leftRightFound[1] && q== node) {
            leftRightFound[1] = true;
        }
        found = leftRightFound[0] & leftRightFound[1];

        if (found && lca.size() == 0) {
            lca.add(node);

        }
        return leftRightFound;
    }

}
