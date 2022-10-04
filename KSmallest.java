// Optimized Approach : Without Using ArrayList

class Solution {
    int count;
    int result = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        count = k;
        inorder(root);
        return result;
    }
    
    public void inorder(TreeNode root){
        if(root == null)
            return;
        
        inorder(root.left);
        
        count--;
        if(count == 0)
            result = root.val;
        
        inorder(root.right);
    }
}

//Time Complexity : O(n)
//Space Complexity : O(n)  -> Recursive Stack only