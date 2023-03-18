//TC: O(n)
//SC: O(h)
class Solution {
    int result ;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
        
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        count--;
        if(count==0){
            result = root.val;
        }
        inorder(root.right);
    }
}
