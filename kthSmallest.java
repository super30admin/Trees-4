// TC- O(h), sc-O(1)
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
    boolean flag; int count;
    public int kthSmallest(TreeNode root, int k) {
       this.count=k;
       this.flag=false;
       inorder(root);
       return result;
    }

    private void inorder(TreeNode root){
        if (root==null) return;
        inorder(root.left);
        count--;
        if(count==0){
            result = root.val;
            flag = true;
        }
        if(!flag){
            inorder(root.right);
        }
    }
}