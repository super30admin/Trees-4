public class KSmallestBst {
    int result;
    int count;
    boolean flag;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root){
        //base
        if(root==null)return ;
        //logic
        if(!flag)
            inorder(root.left);
        count-=1;
        if(count==0){
            flag = true;
            result = root.val;
        }
        if(!flag)
            inorder(root.right);
    }
}
