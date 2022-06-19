/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int kthSmallest(TreeNode root, int k) 
    {
        
        Stack<TreeNode> stack = new Stack<>();
        
        int count = k;
        
        while(root != null || !stack.isEmpty())
        {
            while(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            
            count--;
            TreeNode current = stack.pop();
            if(count == 0)
                return current.val;
            
            root = current.right;
        }
        
        
        return Integer.MAX_VALUE;
        
    }
}