//TC = O(n)
//SC = O(h)
//Here we are using using inorder traversal then will pick the kth element.

class Solution{
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return result;
    }
    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        count--;
        if(count == 0){
            result = root.val;
        }
        helper(root.right);
    }
}