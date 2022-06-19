// Time Complexity : O(N)
// Space Complexity : O(H) - Lists size + O(H) Stack space
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Backtracking soln
class Solution {
    List<TreeNode> path1;
    List<TreeNode> path2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backtrack(root, p, q, new ArrayList<>());
        int i = 0;
        // when we find the unequal couterparts, we stop the loop, use this index minus one to get the LCA
        while(i < path1.size() && i< path2.size() && path1.get(i) == path2.get(i)) {
            i++;
        }
        return path1.get(i-1);
    }
    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        if(root == null) return;
        path.add(root);
        if(root == p) {
            path1 = new ArrayList<>(path);
        }
        if(root == q) {
            path2 = new ArrayList<>(path);
        }
        backtrack(root.left, p, q, path);
        backtrack(root.right, p, q, path);
        path.remove(path.size() -1);
    }
}

// Effecient SOln : Stack space is still there as above, incase of space, Time: O(N)


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        else if(left == null && right != null) return right;
        else if(left != null && right == null) return left;
        else return null;
    }
}
