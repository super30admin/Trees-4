//Time complexity: O(N)
//space complexity: O(h)

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
        if(root == null)
            return -1;
        
        inorder(root, k);
        return result;
    }
    
    private void inorder(TreeNode root, int k){
        //base
        if(root == null) return;
        //logic
        inorder(root.left, k);
        count++;
        if(k == count){
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }
}