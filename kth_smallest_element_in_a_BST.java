// Time Complexity :O(h+k), where h is the height and k is the number of smallest element to be found
// Space Complexity :O(h), where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three Liner explanation of your code in plain English
//1. Start DFS from the root node, and after you hit the first NULL(leftmost node), start decrementing k (as left-most node of a BST
        //has the smallest value)
//2. After decrementing k, check if k has become 0, if yes you found the kth smallest element
//3. else move to the right subtree and continue the DFS as above

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
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        result = 0;
        count =k;
        backtrack(root);
        return result;
    }
    
    public void backtrack(TreeNode root){
        //base
        if(root == null) return;
        //logic
        //action
        //go the left subtree
        backtrack(root.left);
        //once the end of the tree is reached, start decrementing the count (because left-most node is the smallest node in a BST)
        count--;
        //if the count became 0, that is the kth smallest element in the BST
        if(count==0){
            result = root.val;
            return;
        }
        //else explore the right subtree
        backtrack(root.right);
    }
}