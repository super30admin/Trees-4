// Time Complexity : O(log n + k)
// Space Complexity : O(log n), stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// push all left elements to stack, this gives 1st smallest on top
// if this node has right child then that would be next smallest
// push all left nodes on right child subtree

class Solution {
    Stack<TreeNode> stack;
    
    private void pushAllLeftChildrenToStack(TreeNode node){
        stack.push(node);
        while(node.left!=null){
            stack.push(node.left);
            node = node.left;
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        stack = new Stack<>();
        
        pushAllLeftChildrenToStack(root);
        
        while(k>1){
            TreeNode node = stack.pop();
            k--;
            if(node.right!=null){
                pushAllLeftChildrenToStack(node.right);
            }
        }
        
        return stack.pop().val;
    }
}