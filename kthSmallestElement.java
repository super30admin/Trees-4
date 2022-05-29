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
//TC : O(n)
//SC : O(h)
class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return root.val;

        count = k;
        helper(root,k);
        return result;
    }

    private void helper(TreeNode root,int k)
    {
        //base
        if(root == null) return;


        //logic
        helper(root.left,k);
        count--;
        if(count==0)
            result = root.val;
        helper(root.right,k);

    }
}