//Time = O(h+k), h is height and k is the smallest
//Space = O(n)

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
    public int kthSmallest(TreeNode root, int k) {
        // Create a stack to keep track of the nodes to be visited
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root; // Set the current node to the root of the tree
        int count = 0; // Keep track of the number of nodes visited so far
        
        // Traverse the tree in inorder fashion
        while(curr != null || !stack.isEmpty()) { // While there are still nodes to visit
            while(curr != null) { // Traverse down the left subtree as far as possible
                stack.push(curr); // Push the current node onto the stack
                curr = curr.left; // Move to the left child of the current node
            }
            
            // We have reached the leftmost node
            curr = stack.pop(); // Pop the current node from the stack
            count++; // Increment the count of nodes visited
            if(count == k) { // If we have visited k nodes, we have found the kth smallest element
                return curr.val; // Return the value of the current node
            }
            
            // Move to the right subtree
            curr = curr.right;
        }
        
        // If k is greater than the total number of nodes in the tree, return -1
        return -1;
    }
}
