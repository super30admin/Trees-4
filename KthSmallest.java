Executed in leet code -Yes

class Solution {
      int result=0;int ct=0;
    public int kthSmallest(TreeNode root, int k) {
         ct=k;
         inorder(root);
        return result;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        ct--;
        if(ct==0){
            result= root.val;
            return;
        } 
        inorder(root.right);
    }
}
