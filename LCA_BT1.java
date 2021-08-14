// Time Complexity : O(n), n = total number of nodes
// Space Complexity : O(H), H = height of the tree
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<TreeNode> path1, path2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        backtrack(root, p, q, new ArrayList<>());
        for(int i=0; i<path1.size(); i++) {
            if(path1.get(i) != path2.get(i))
                return path1.get(i-1);
        }
        return root;
    }
    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        //base case
        if(root == null)
            return;
        if(root == p) {
            path1 = new ArrayList<>(path);
            path1.add(p);
            path1.add(p);
        }
        if(root == q) {
            path2 = new ArrayList<>(path);
            path2.add(q);
            path2.add(q);
        }
        //action
        path.add(root);
        backtrack(root.left, p, q, path); //recurse
        backtrack(root.right, p, q, path);
        path.remove(path.size()-1); //backtrack
    }
}