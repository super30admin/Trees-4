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
//Time: O(n)
//Time: O(n)
class Solution {
    int result, count;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;
        result = -1;
        inorder(root, k);
        return result;
    }
    
    private void inorder(TreeNode root, int k){
        if(root == null)
            return;
        if(result == -1)
            inorder(root.left, k);
        count++;
        if(count == k){
            result = root.val;
            return;
        }
        if(result == -1)
            inorder(root.right, k);
            
    }
}
