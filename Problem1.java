//Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree (due to recursion stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
// 1. We perform an inorder traversal of the binary search tree (BST) to get the elements in sorted order.
// 2. We maintain a count initialied to k  and decrement it once we visited the nodes.
// 3. When the count becomes 0, we store the value of the current node as the result and return it.




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
    int count=0;
    int res=-1;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        findkthSmallest(root);
        return res;
    }
    public void findkthSmallest(TreeNode root){
        if(root==null){
            return;
        }
        //inorder traversal of BST gives the elements in sorted order
        //so we traverse the left subtree first, then the root, and then the right subtree
        findkthSmallest(root.left);
        //decrement the count of elements visited so far
        count--;
        //if the count is equal to 0, then we have found the kth smallest element
        if(count==0){
            res=root.val;
        }
        //inorder traversal continues to the right subtree
        findkthSmallest(root.right);
    }
}