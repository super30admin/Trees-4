/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


**/
class Solution 
{
    public int kthSmallest(TreeNode root, int k) 
    {
    
        int count = k;
        
        
        Stack<TreeNode> stack = new Stack<>();
        
        while( !stack.isEmpty() || root != null)
        {
            
            while(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            
            TreeNode current = stack.pop();
            count--;
            
            if(count == 0)
                return current.val;
            
            root = current.right;
        }
        
        
        return -1;
        
    }
}