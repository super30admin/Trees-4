// TC: O(n)
// SC: O(n)
class Solution {
    List<TreeNode> path1, path2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();

        backtrack(root, p, path1);
        backtrack(root, q, path2);

        for(int i = 0; i < path1.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                return path1.get(i - 1);
            }
        }
        return null;
    }
    private void backtrack(TreeNode root, TreeNode p, List<TreeNode> path) {
        if(root == null) {
            return;
        }
        if(root == p) {
            path.add(root);
        }
        path.add(root);
        backtrack(root.left, p, path);
        if(path.get(path.size() - 1) == p) {
            return;
        }
        backtrack(root.right, p, path);
        if(path.get(path.size() - 1) == p) {
            return;
        }
        path.remove(path.size() - 1);
    }
}