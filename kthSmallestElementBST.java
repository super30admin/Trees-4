// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : We take advantage of the BST property i.e, left subtree<root<right sub tree. We also know that infix traversal o BST is sorted.
/// So let's maintain a count value =k and traverse the tree inorder. KEep decrementing count whenever we reach a node, and when
/// we reach count = 0 then we found the kth smallest node return its value

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
    int count, result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        result = Integer.MAX_VALUE;
        helper(root);
        return result;
    }
    private void helper(TreeNode root){
        if(root == null){
            return;
        }
        if(result!= Integer.MAX_VALUE){
            return;
        }
        helper(root.left);
        count--;
        if(count == 0){
            result = root.val;
        }
        helper(root.right);
    }
}