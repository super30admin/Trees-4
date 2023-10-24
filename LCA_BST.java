class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null){
            return root;
        }
        return lca(root, p,q);
    }
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        //base
        if(root == null){
            return null;
        }

        //logic
        if(root.val > p.val && root.val > q.val){
            return lca(root.left,p,q);
        }
        else if(root.val<p.val && root.val <q.val){
            return lca(root.right, p, q);
        }
        else{
            return root;
        }
    }
}