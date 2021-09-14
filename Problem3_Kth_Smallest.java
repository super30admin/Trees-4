class Solution {
    int cnt; // default value will be 0;
    int result;
    
    public int kthSmallest(TreeNode root, int k) {
        //Base 
        if(root==null){
            return -1;
        }
        result = -1;
        inorder(root, k);
        return result;
    }
    
    public void inorder(TreeNode root, int k){
            //base
            if(root==null){
                return ;
            }
            //logic
            inorder(root.left, k);
            if(++cnt == k){
                result = root.val;
            }
            inorder(root.right, k);
        }
}
