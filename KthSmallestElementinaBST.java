// Time Complexity : O(n)
// Space Complexity : O(h) height of the tree

/*
 * here we perfrom an inorder traversal and keep a count of all the 
 * elements visited from the leaf and when we reach the kth element
 * we set that value as result.
 */


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
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root, k);
        return result;
    }

    public void inorder(TreeNode root, int k){
        // base
        if(root == null) return;

        //logic
        inorder(root.left, k);
        count--;
        if(count == 0) {
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }
}