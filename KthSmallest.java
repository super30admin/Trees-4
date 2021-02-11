// Time Complexity : The time complexity is O(k)
// Space Complexity : The space complexity is O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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

    int smallest;
    boolean isSmall;
    int pos;

    public int kthSmallest(TreeNode root, int k) {

        dfs(root,k);
        return smallest;

    }

    // Inorder traversal
    public void dfs(TreeNode root, int k){

        if(root == null){
            return;
        }

        dfs(root.left,k);
        pos++;

        if(isSmall){
            return;
        }

        // Traverse till the kth smallest
        if(pos == k){
            isSmall = true;
            smallest = root.val;
        }

        dfs(root.right,k);
    }
}