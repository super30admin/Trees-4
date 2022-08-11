class LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }
    //TC is O(n)
    //SC is O(h)
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        // base case
        if(root == null || root.val == p.val || root.val == q.val)
            return root;
        
        //left
        TreeNode left = dfs(root.left,p,q);
        
        //right
        TreeNode right = dfs(root.right,p,q);
        if(left == null && right==null){
            return null;
        }else if(left == null && right != null) return right;
        else if(left != null && right == null) return left;
        else return root;
    }
}
