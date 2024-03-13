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
 This code implements a solution to find the kth smallest element in a binary search tree (BST) using an inorder traversal approach.
  It recursively performs an inorder traversal, counting nodes as it traverses, and stops when it reaches the kth node, returning its value. 
  Finally, it returns the value of the kth smallest element found during the traversal.
  Time Complexity: O(N)
  Space Complexity: O(H)
  */
class Solution {
    int res;
    int cnt;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return res;
        
    }
    private void inorder(TreeNode root, int k){
        if(root == null) return;
        inorder(root.left,k);
        cnt++;
        if(cnt == k){
            res = root.val;
        }
        inorder(root.right, k);
    }
}
