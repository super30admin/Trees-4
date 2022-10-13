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
 //tc-o(n)
 //sc-o(h)
 class Solution {
    int result;
    int count;
    boolean flag;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root)
    {
        if(root == null) return;
        if(!flag)
        inorder(root.left);
        count--;
        if(count == 0)
        {
        flag = true;
        result = root.val;
        }
        if(!flag)
        inorder(root.right);


    }
}