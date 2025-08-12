// Time Complexity : O(n)
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I did a DFS in order - it will be in sorted order since it is a BST, i.e., all left values are smaller than root and right are greater than it. Everytime I pop - it is the current smallest element, so I reduce k. Once k==0, it means I am on the right node and I can return it. Else I keep traversing inorder.

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
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if(k==0) return root.val;
            root = root.right;
        }
        return -1;
    }
}