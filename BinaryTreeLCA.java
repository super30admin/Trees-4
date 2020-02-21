
public class BinaryTreeLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
            
        if(root.val == p || root.val == q)
            return root;

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        if(leftLCA != null && rightLCA != null){
            return root;
        }
        return leftLCA != null ? leftLCA : rightLCA;
    }


}