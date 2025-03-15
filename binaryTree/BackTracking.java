package binaryTree;

//Time Complexity:O(n) where n is the number of nodes in the tree.
//Space Complexity:O(h) where h is the height of recursive stack space

class BackTracking {
    List<TreeNode> pathP = new ArrayList();
    List<TreeNode> pathQ = new ArrayList();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        backtrack(root, p, q, new ArrayList());

        for(int  i = 0; i < pathQ.size(); i++) {

            if(pathQ.get(i) != pathP.get(i)) {
                return pathQ.get(i - 1);
            }
        }

        return null;

    }

    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {

        // base
        if(root == null) {
            return;
        }

        // logic
        // action
        path.add(root);

        //  last node logic
        if(root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }

        if(root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }

        // recurse
        backtrack(root.left, p, q, path);
        backtrack(root.right, p, q, path);

        // backtrack
        path.remove(path.size() - 1);
    }
}