//TC: O(n) — DFS may visit every node once; path comparison is O(h) ≤ O(n).
//SC: O(h) — recursion stack plus storing two root→node paths (each O(h)), where h is tree height.

//Do a DFS from root keeping a running path; when you hit p or q, clone path into pathP/pathQ and continue until both found.
//Compare pathP and pathQ from index 0; the last index where nodes match is the LCA.
//Handle missing nodes by returning null; if one path is a prefix of the other, the LCA is the end of the shorter path.

class Solution {
    private List<TreeNode> pathP = null;
    private List<TreeNode> pathQ = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q, new ArrayList<>());

        if (pathP == null || pathQ == null) return null; // one or both not found

        int m = Math.min(pathP.size(), pathQ.size());
        TreeNode lca = null;
        for (int i = 0; i < m; i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                lca = pathP.get(i);
            } else {
                break;
            }
        }
        return lca;
    }

    private void dfs(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> path) {
        if (node == null || (pathP != null && pathQ != null)) return;

        path.add(node);

        if (node == p) pathP = new ArrayList<>(path); // no extra add of node
        if (node == q) pathQ = new ArrayList<>(path);

        dfs(node.left, p, q, path);
        dfs(node.right, p, q, path);

        path.remove(path.size() - 1);
    }
}