//Time Complexity: O(n)
//Space Complexity: O(h)
//Code run successfully on LeetCode.

public class Problem1_1 {

    int count;
    int result = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null)
            return -1;
        
        count = k;
        inorder(root);
        return result;
    }
    
    private void inorder(TreeNode root){
        
        if(root == null)
            return;
        
        if(result == -1)
           inorder(root.left);
        
        count--;
        if(count == 0)
        {
            result = root.val;
            return;
        }
        
        if(result == -1)
          inorder(root.right);
    }
}
