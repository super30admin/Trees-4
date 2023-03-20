/*
LCA of a Binary Tree
approach:
1. use a bottom-up recursion to return root if we found something on left or right or left & right
2. use a top-down recursion to record the path of p and q, after iterate on path and where the elements of 2 paths
 not same that is lca
 time: both: O(n)
 space: both: O(h)
 */
public class Problem3 {
    /*
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val) {
            return root;
        }
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        if(left !=null && right!=null) return root;
        else if(left==null && right!=null) return right;
        else if(right==null && left!=null) return left;
        return null;
    }

     */
}
