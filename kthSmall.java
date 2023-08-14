// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        inorder(root);
        return result;
    }
    
    private void inorder(TreeNode root){
        if(root==null) return;
        
        inorder(root.left);
        count--;
        if(count==0)
            result= root.val;
        inorder(root.right);
    }
}
