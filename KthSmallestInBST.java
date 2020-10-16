/* Approach: 230. Kth Smallest Element in a BST
https://leetcode.com/problems/kth-smallest-element-in-a-bst/

Did this code successfully run on Leetcode : Yes

An inorder travesal of a BST returns elements in a sorted fashion.
Keep a counter as we do an inorder traversal on the BST and return the element once we hit k.
*/

import java.util.Stack;

public class KthSmallestInBST {
    // Recursive approach
    // TC: O(n) - may need to visit all nodes
    // SC: O(h) - statck space for recusrion
    int count = 0, val = 0;
    public int kthSmallestRec(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return val;
    }
    
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inOrder(root.left);
        
        if (--count == 0) {
            val = root.val;
            return;
        }
        
        inOrder(root.right);
    }
    
    // Iterative approach
    // TC: O(n) 
    // SC: O(1) - constant space
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        int val = 0;
        
        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            
            TreeNode node = st.pop();
            if (--k == 0) {
                val = node.val;
                break;
            }
            
            root = node.right;
        }
        return val;
    }
}