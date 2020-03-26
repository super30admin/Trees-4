// Time Complexity : O(n) where n is number of digits in number
// Space Complexity : O(h);h -> height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : Main intuition is that the inorder traversal of BST gives result in sorted order.
// 1. Maintaining a global result and count.
// 2. DFS traversal in inorder fashion will explore the nodes in sorted order. Whenever k traversals are done, respective element is returned. 
// 3. count variable is used to keep track of k traversals.

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
    int result = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root  == null)
            return 0;
        inorder(root, k);
        return result;
    }
    
    private void inorder(TreeNode root, int k) {
        if(root == null)
            return;
        inorder(root.left, k);
        if(++count == k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }
    
    
}

