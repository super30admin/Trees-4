// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

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
    //initialize count and res
    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        //have the recursion
        inorder(root, k);
        //return the result
        return res;
    }

    private void inorder(TreeNode root, int k){
        //base
        //check if you hit leaf node
        if(root == null) return;
        //logic
        //call recursion on the root left
        inorder(root.left, k);
        //when null hits and return a st.pop() will occur here
        //increase the count after the pop
        count++;
        //check if count equal k
        if(count == k){
            //set the result to the root.val
            res = root.val;
            //then return
            return;
        }
        //if it doesn't equal k then go to root.right recursively
        inorder(root.right, k);
    }
}