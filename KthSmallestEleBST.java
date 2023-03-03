// TC : O(n)
// SC : O(h)

class Solution {
    int count = 0;
    TreeNode res;
    public int kthSmallest(TreeNode root, int k) {     
        inorder(root, k);
        return res.val;
    }
    private void inorder(TreeNode root, int k){
        if(root == null)
            return;
        if(count<k)
            inorder(root.left,k);
        count++;
        if(count == k) {
            res = new TreeNode(root.val);
        }
        if(count<k)
            inorder(root.right, k);
    }
}