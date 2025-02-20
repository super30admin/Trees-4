// TC: O(n)
// SC: O(h) h is height of the tree

public class LC230 {
    int res = -1, k =0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder( root);
        return res;
    }
    public void inorder(TreeNode root){
        if(root == null || res != -1) return;
        inorder(root.left);
        k--;
        if(k == 0) {
            if(res == -1) res = root.val;
            return;
        }
        inorder(root.right);
    }
}
