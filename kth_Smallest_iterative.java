// Time complexity : O(n)
// Space complexity : O(n) - Recursive Stack

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int x;
    
    public int kthSmallest(TreeNode root, int k) {
        
        // Iterative approach
        x = k; 
        
        // Stack to store the root nodes
        Stack <TreeNode> stack =  new Stack<>();
        
        // Traverse through each root node : Inorder Traversal
        while (!stack.isEmpty() || root != null){
            
            // left sub tree
            while ( root != null){
                
                stack.push(root);
                root = root.left;
            }
            
            // node
            k--;
              
            // Go to the parent to start the right sub tree
            root = stack.pop();
            
            if (k == 0){
                return root.val;
            }
            
            //right sub tree
            root = root.right;
            
        }
        
        
        // Invalid (node not found)
        return -1;
    }
    
}