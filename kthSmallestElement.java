//Time Complexity: O(n) we will traverse only k nodes
//Space Complexity: O(n) for recursion stack
//Did run on leetcode: yes
/** Approach: I basically did an iterative inorder traversal and kept count on each popped node
    when count = k make that node value as output**/

class Solution {
        
    public int kthSmallest(TreeNode root, int k) {
        //base case
        if(root==null)
            return -1;
        
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        
        while(!stack.isEmpty() || root!=null){
            
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            
            if(root==null){
                TreeNode popped = stack.pop();
                count += 1;
                if(count==k)
                    return popped.val;
                root = popped.right;
            }
        }
        
        return -1;
    }
}
