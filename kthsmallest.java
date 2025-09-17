//TC: O(n) (skewed tree or k = n).
//SC: O(h) recursion stack (no extra structures), where h is tree height.

//Do an in-order traversal (left → node → right) while maintaining a global count.
//Recurse left; on return, increment count and when count == k, record result and short-circuit further work.
//If not found yet (result == null), recurse right; finally return result.val.

class Solution {
    int count;
    TreeNode result;

    public int kthSmallest(TreeNode root, int k) {
        this.count = 0;
        helper(root, k);
        return result.val;
    }

    private void helper(TreeNode root, int k) {
        if (root == null) return;

        if (result == null)
            helper(root.left, k);

        count++;
        if (count == k) {
            result = root;
        }

        if (result == null)
            helper(root.right, k);
    }
}