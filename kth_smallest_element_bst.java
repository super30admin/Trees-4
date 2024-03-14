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

 // inorder 
 //TimeComplexity: O(n)
 //SpaceComplexity:O(h)
class Solution {
    int count =0;
    int result=0;
    void recursiveInorder(TreeNode root, int k) {
          //base
           if(root == null) {
            return;
           }
          //logic
          recursiveInorder(root.left,k);
          count++;
          if(count == k) {
              result = root.val;
              return;
          }
          recursiveInorder(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        recursiveInorder(root,k);
        return result;
    }
}