class Solution {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    public void helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || result != null) return;
        
        //logic
        if(root.val > p.val && root.val > q.val){
            helper(root.left, p, q);
        }
        else if (root.val < p.val && root.val < q.val){
            helper(root.right, p, q);
        }else {
            result = root;
            return;
        }
    }
}
