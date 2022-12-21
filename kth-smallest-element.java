import java.util.*;

//TC is O(h)
//SC is O(h)
class Solution {
    int count;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;

        result = -1;

        dfs(root, k);

        return result;

    }

    private void dfs(TreeNode root, int k) {
        // base
        if (root == null)
            return;

        // recurse

        dfs(root.left, k);

        count++;
        if (count == k) {
            result = root.val;
            return;
        }

        dfs(root.right, k);
    }
}