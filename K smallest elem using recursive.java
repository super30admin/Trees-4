// Time complexity - 0(n)
// space complexity - 0(n)
// code successfully executed in leetcode

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
    int count;
    int res =-1;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return res;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        count--;
        if(count == 0) res = root.val;
        inorder(root.right);
        
    }
        }