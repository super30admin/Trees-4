// TC : O(log(n))
// SC : O(h)
class Problem230 {
    TreeNode result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        inorder(root);
        return result.val;
    }
    private void inorder(TreeNode root){
        if(root==null)
            return;
        if(result==null)
            inorder(root.left);
        count--;
        if(count==0){
            result=root;
        }
        if(result==null)
            inorder(root.right);
    }
}
