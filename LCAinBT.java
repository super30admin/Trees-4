// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: yes
// Any problem you faced while coding this: yes
// Your code here along with comments explaining your approach: 3 flags for finding p or q in left and right or mid for if found in current node

public class LCAinBT {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isFound(root, p, q);
        return ans;
    }

    private boolean isFound(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;

        int left = isFound(root.left, p, q) ? 1 : 0;
        int right = isFound(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;

        if (left + right + mid >= 2) {
            ans = root;
        }
        return (left + right + mid > 0);

    }
}
