// Time Complexity : O(n)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach



//Iterative approach
class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
      
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            
            while(root!=null){
                stack.push(root);
                root = root.left;
                
            }
          
            root = stack.pop();
            k--;
            if(k == 0){
                return root.val;
            }
            root = root.right;
            
        }
        
        return -1;
    }
    
   
}


//recursive approach



// Time Complexity : O(n)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
	
class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        
      count = k;    
      helper(root);  
        
        return result;
    }
    
    
    private void helper(TreeNode root){
        
        
        if(root == null)
            return ;
        
        helper(root.left);
        count--;
        if(count == 0 )
            result = root.val;
        helper(root.right);
        
        
    }
}