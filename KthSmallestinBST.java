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
/**
 * TC: O(h + k) ~ O(n + k) for skewed trees
 * SC: O(h) h is the height of the tree
 * Approach: The inorder traversal of a BST gives the nodes in ascending order
 *           So do an inorder traversal, and return the kth element in the traversal
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // edge case
        if(root == null) {
            return -1;
        }
        // initialize stack
        Stack<TreeNode> st = new Stack<>();
        // track current
        TreeNode current = root;
        
        while(current != null || !st.isEmpty()) {
            // move as far left as possible
            while(current != null) {
                st.push(current);
                current = current .left;
            }
            // pop
            current = st.pop();
            
            // update k
            k--;
            
            // check if the current node is the kth node in the inorder traversal of BST
            if(k == 0) {
                return current.val;
            }
            
            // move right
            current = current.right;
        }
        
        // return -1 no relevant element found
        return -1;
    }
}
