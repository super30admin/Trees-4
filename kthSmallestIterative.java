// Time Complexity :O(n) n is the number of nodes
// Space Complexity :O(h) height of stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int count;int result;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        count = k;
        helper(root);
        return result;
    }
    
    private void helper(TreeNode root){
        //base case
        if(root == null) return;
        
        //logic
        helper(root.left);
        count--;
        if(count == 0){
            result = root.val;
        }
        else{
            helper(root.right);
        }
    }
}
class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        Stack<TreeNode> st = new Stack<>();
        while(root !=null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            
            root = st.pop();
            
            k--;
            if(k==0) {
                return root.val;
            }else{
                root = root.right;
            }
            
            
        }
        
        return 0;
    }
    
}