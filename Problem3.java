// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//230. Kth Smallest Element in a BST
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/


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
    // recursion (return)
    // time: O(n)
    // space: O(h)
    int count;

    public int kthSmallest(TreeNode root, int k) {

        count = k;
        return inorder(root);

    }

    private int inorder(TreeNode root) {
        // base
        if (root == null)
            return Integer.MAX_VALUE;

        // logic
        int left = inorder(root.left);
        System.out.print(left + " ");
        System.out.print(root.val + " ");
        System.out.println(count);
        if (left != Integer.MAX_VALUE)
            return left;
        count--;
        if (count == 0) {
            return root.val;
        }

        return inorder(root.right);

    }
}


/*
class Solution {
    //recursion (no return )
    //time: O(n)
    //space: O(h)
    int count = 0;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        
        inorder(root, k);
        return result;
    }
    
    private void inorder(TreeNode root, int k){
        //base
        if(root == null) return;
        
        //logic
        inorder(root.left, k);
        count++;
        if(count == k){
            result = root.val;
        }
        
        inorder(root.right, k);
        
    }
}
*/
