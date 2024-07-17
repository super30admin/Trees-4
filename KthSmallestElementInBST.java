// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//  In-order Traversal Setup: Use a stack to simulate the in-order traversal iteratively.
//Traverse Left Subtree: Push all left children onto the stack until you reach a leaf node.
//Visit Node and Move to Right Subtree: Pop nodes from the stack, decrement k, and if k is 0, return the node's value. Otherwise, move to the right child and repeat.

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

// iterative method

class Solution {
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> s= new Stack<>();
        while(root!= null || !s.isEmpty()){
            while(root!= null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if(k==0){
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}
