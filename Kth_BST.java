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
    //Time O(k)
    //Space O(H)
    int count = 0 , ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
        {
            return -1;
        }
        helper(root , k);
        return ans;
    }
    public void helper(TreeNode root , int k)
    {
        //base
        if(root == null) return;
        //logic
        helper(root.left , k);
        count++;
        if(count == k)
        {
           ans = root.val;
            return;
        }
        helper(root.right , k);
    }
}