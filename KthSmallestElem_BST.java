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

 /*
 Approach: Use inorder traversal to get the values in sorted order of BST
 */
// Time: O(n)
// Space: O(h) - size of recursion stack

class Solution {

    int count=0;
    int res=0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }
    //inorder traversal
    public void dfs(TreeNode root, int k){

        if(root==null)
            return;

        dfs(root.left,k);

        count++;
        if(count==k){
            res=root.val;
            return;
        }
        dfs(root.right,k);
    }
}