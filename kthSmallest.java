public class kthSmallest {
    int count;
    int result;
    boolean flag;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root){
        if(root==null) return;

        // logic
        if(!flag) inorder(root.left);
        count--;
        if(count==0){
            flag = true;
            result = root.val;
        } 
        if(!flag) inorder(root.right);
    }
}

// TC - O(n)
// SC - O(h)
