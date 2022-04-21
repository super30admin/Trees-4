
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Without Recursion

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            //AFTER Stack.pop() decrement counter, 
            //If count is equals to 0, we got our kth smallest element in given BST
            if(k == 0)  return root.val;
            root = root.right;
        }
        return 9999;
    }
}


/*
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


class Solution {
    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        
        helper(root.left); 
        //AFTER Stack.pop() decrement counter, 
        //If count is equals to 0, we got our kth smallest element in given BST
        count--;
        if(count == 0)  {
            res = root.val;
            return;
        }
        
        helper(root.right);
    }
}

/*
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    
    int count;
    TreeNode data;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        
        helper(root, k);
        return data.val;
        
    }
    public void helper(TreeNode root, int k){
        if(root == null)    return;
        
        helper(root.left, k); 
        //AFTER Stack.pop() increment counter, 
        //If it is equals to K, we got our kth smallest element in given BST
        count++;
        if(count == k)  {
            data = root;
            return;
        }
        
        helper(root.right, k);
    }
}
*/


