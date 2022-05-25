// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int count, result;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        count = k;
        result = 0;
        
        inorder(root);
        return result;
    }
    
    private void inorder(TreeNode node) {
        
        if(count != 0) {
           if(node == null) return;
        
            inorder(node.left);
        
            count--;
            
            if(count == 0) {
                result = node.val;
                return;
            }
            
            inorder(node.right);
        }
    }
}