/* Time Complexity : O(n) 
*   n - total number of elements in a tree */
/* Space Complexity : O(h) 
*   h - height of recursive stack */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
//recursion
class Solution {
    int count;
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k);       
    }

    private int inorder(TreeNode root, int k){
        //base condition
        if(root == null) return 0;
        //logic
        //recurse
        int result = inorder(root.left, k);
        count++;
        if(count == k){
            result = root.val;
        }
        //Conditional recursion
        if(count < k)
            result = inorder(root.right, k);
        return result;
    }
}

 //recursion - void
/*
class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;        
    }

    private void inorder(TreeNode root, int k){
        //base condition
        if(root == null) return;
        //logic
        //recurse
        inorder(root.left, k);
        count++;
        if(count == k){
            result = root.val;
            return;
        }
        //Conditional recursion
        if(count < k)
            inorder(root.right, k);
    }
}*/