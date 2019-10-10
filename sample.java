// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach: traverse BST in inorder traversal, 
// this would give values in increasing order and kth smallest elem would be kth element in this order.
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
    int val = 0;
    int count =0;
    public int kthSmallest(TreeNode root, int k) {
        func(root,k);
        return val;
    }
    public void func(TreeNode node, int k){
        if(node==null) return;
        func(node.left,k);
        count++;
        if(count==k){
            val=node.val;
            return;
        }
        func(node.right,k);
    }
}
