// TC : O(H)
// SC : O(H)

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
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[2];
        traverse(root,result,k);
        return result[1];
    }
    
    public void traverse(TreeNode root, int[] result, int k) {
        if(root == null)
            return;
        
        
        traverse(root.left, result, k);
            
        if(++result[0] == k){
            result[1] = root.val;
            return;
        }
        
        traverse(root.right, result, k);
    }
}
