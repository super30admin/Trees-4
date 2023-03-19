/*
LCA of a BST
approach: check the root value where both p and q are diverging
time: O(h)
space: O(h)
 */
public class Problem2 {
    /*
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,  p,  q);
        return res;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return ;
        if(p.val<root.val && q.val<root.val) {
            helper(root.left, p,  q);
        }
        else if(p.val>root.val && q.val>root.val) {
            helper(root.right, p,  q);
        }
        else res = root;

    }

     */
}
