
Time: O(H) where H is the height of the tree
Space: O(H) auxilliary space


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;
        // initialize stack
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = root.left;
        
        while(true) {
            
            //push left subtree's left nodes to stack till null
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        
            // pop from stack
            curr = stack.pop();
            // check if it is kth smallest element
            if(--k == 0) 
                return curr.val;
            // if not yet found, traverse right subtree till kth element is found
            curr = curr.right;
        }
    }
    
    
}
