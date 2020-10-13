//TC: O(K) where k is the depth of the root
//SC: O(1)
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}