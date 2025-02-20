// TC: O(n)
// SC: O(h) where h is the height of the tree

public class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if(l==null && r==null) return null;
        if(l==null || r==null) return (l==null) ? r : l;
        return root;
    }
}