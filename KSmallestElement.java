public class KSmallestElement {
    int result;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k, new ArrayList<>());
        return result;
    }

    //TC is O(n)
    //SC is O(h)
    private void dfs(TreeNode root, int k, List<TreeNode> list) {
        // base
        if (root == null)
            return;

        // left

        dfs(root.left, k, list);
        list.add(root.left);
        if (list.size() == k) {
            result = root.val;
            return;
        }
        // right
        dfs(root.right, k, list);
    }
}
