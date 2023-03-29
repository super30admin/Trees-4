// TC: O(n)
//SC: O(1)
class Solution {
    int result = -1, k;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return result;
        }
        this.k = k;
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            k--;
            if(k == 0) {
                result = root.val;
                return;
            }
            if(k > 0) {
                inorder(root.right);
            }
        }
    }
}