/*
Kth smallest element in a BST
approach: do a inorder traversal and decrement k at each node
time: O(n)
space: O(h)
 */
public class Problem1 {
    int res = 0, n;
    /*
    public int kthSmallest(TreeNode root, int k) {
        n = k;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if(root==null) return;
        if(root.left!=null) inorder(root.left);
        n--;
        if(n==0) {
            res = root.val;
        }
        if(root.right!=null) inorder(root.right);


    }

     */
}
