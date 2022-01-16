// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use backtracking to solve this
// We take two lists to store the paths till we find the given nodes
// Once the traversal is done 
// We iterate over the lists and when the paths have different nodes we return the previous node as answer

class Solution {
    List<TreeNode> ppath;
    List<TreeNode> qpath;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        backtrack(root, p, q, new ArrayList<>());
        for (int i = 0; i < ppath.size(); i++) {
            if (ppath.get(i) != qpath.get(i))
                return ppath.get(i - 1);
        }
        return null;
    }

    public void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        if (root == null)
            return;
        path.add(root);
        if (root.val == p.val) {
            ppath = new ArrayList<>(path);
            ppath.add(p);
        }
        if (root.val == q.val) {
            qpath = new ArrayList<>(path);
            qpath.add(q);
        }
        backtrack(root.left, p, q, path);
        backtrack(root.right, p, q, path);
        path.remove(path.size() - 1);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use bottom up recursion to solve this
// We call the recursion on the left subtree and right tree and we check their
// values
// we return the result based on the conditions

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null)
            return null;
        else if (left == null && right != null)
            return right;
        else if (left != null && right == null)
            return left;
        else
            return root;
    }

}