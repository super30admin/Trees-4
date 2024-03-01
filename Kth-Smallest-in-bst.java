// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using dfs, keeping track of count when visiting the left and right nodes of the root.

// 230. Kth Smallest Element in a BST

// Recursive

 // Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
  

class Solution {
    int count = 0;
    int res = Integer.MIN_VALUE;
    void helper(TreeNode root,int k){
        if(root == null){
            return;
        }
        helper(root.left,k);
        count++;
        if(count == k){
            res = root.val;
            return;
        }
        helper(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return res;
    }
}
