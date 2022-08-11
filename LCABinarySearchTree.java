public class LCABinarySearchTree {
    //TC is O(h)
    //SC is O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left,  p,  q);
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,  p,  q);
        else return root;
    }
}
