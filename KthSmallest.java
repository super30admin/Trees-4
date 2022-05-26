public class KthSmallest {

    // TC : O(n) n - number of nodes in a tree
    // SC : O(h) h - height of the tree
    int result = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return result;

        count = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if(root == null) return;

        dfs(root.left);

        count--;
        if(count == 0) result = root.val;

        dfs(root.right);
    }
}
