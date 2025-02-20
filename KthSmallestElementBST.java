class KthSmallestElementBST {
    int result, k;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        this.k = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        k--;
        if(k==0){
            result = root.val;
        }
        dfs(root.right);
    }
}
