class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        inorder(root);
        return result;
    }
    public void inorder(TreeNode root) {
        if(root == null){
            return;
        }

        inorder(root.left);

        count--;
        if(count == 0){
            result = root.val;
        }

        inorder(root.right);
    }
}