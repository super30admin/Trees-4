// Time Complexity :O(N)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack();
        // stack.push(root);
        
        while(!stack.isEmpty() || root != null){ 
        
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0)
                return root.val;
            root = root.right;
        }
        return 0;
    }
}