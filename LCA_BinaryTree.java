//TC - O(n)
//SC - O(n)
class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        dfs(root, p, q, new ArrayList<>());
        for(int i=0; i<pathP.size(); i++) {
            if(pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i - 1);
            }
        }
        return null;
    }
    public void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base
        if(root == null || (pathP.size() > 0 && pathQ.size() > 0)) {
            return;
        }

        // logic
        path.add(root);
        if(root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        path.remove(path.size() - 1);
    }
}