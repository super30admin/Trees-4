// USING : inorder
// TC : O(n)
// SC : O(h)

class Solution {
    int result;
    int count;
    boolean flag;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result; 
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        if(!flag)
            inorder(root.left);
        
        //root
        count--;
        if(count == 0){
            flag = true;
            result = root.val;
        }

        if(!flag) inorder(root.right);
    }
}


