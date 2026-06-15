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
    int cnt;
    int result;
    boolean flag;
    public int kthSmallest(TreeNode root, int k) {
        this.cnt=0;
        this. result =0;
        helper(root,k);
        return result ;
    }
    private void helper(TreeNode root, int k){
        if(root==null) return;

        helper(root.left,k);
        cnt++;
        if(cnt==k){
            flag = true;
            result= root.val;
        }
        if(!flag) helper(root.right,k);
    }
}

// to learn inorder iterative sol 