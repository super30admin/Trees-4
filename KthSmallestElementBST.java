// Time O(N) 
// Space O(h) h is the height of the tree

public class KthSmallestElementBST {
    int count;
    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return result.val;
    }
    
    public void helper(TreeNode root){
        // base condition
            if(root==null || count==0){
                return;
            }
        
        // logic
        helper(root.left);    
        // pop
        count--;
        if(count == 0)
        {
               result = root;
               return;
        }
        helper(root.right);
       
    }
}
