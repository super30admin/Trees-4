// Time: O(n)
//Space: O(edge+k)
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
    int count;
    public int kthSmallest(TreeNode root, int k) {
        result = -1;
        inorder(root,k);
        return result;
    }
    private void inorder(TreeNode root, int k){
        if(root == null) return;
        
        inorder(root.left,k);
        count++;
        if(count == k){
          result = root.val;
            return;
        }
        if(result == -1) inorder(root.right,k);
    }
}