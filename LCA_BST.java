//Time Complexity: O(h) where h is the height of the tree
// Space Complexity: O(1) for the recursive stack space

public class LCA_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) // if root is less then values will lie in right subtree
            return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root; // this is the split case
    }
}
