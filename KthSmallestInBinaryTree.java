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
 
 TC - O(N) when k = N
 SC - O(H) when K=N in the case of skewed tree.
 
 
 */
class Solution {
    
    int result = -1;
    int k;
    
    public int kthSmallest(TreeNode root, int k) {
        
        this.k = k;
        kthSmallestHelper(root);
        return result;
    }
    
    private void kthSmallestHelper(TreeNode root)
    {
        // base case 
        if (root == null)
        {
            return;
        }
        
        // left traversal
        kthSmallestHelper(root.left);
        
        // root visit this and decrease k by 1
        this.k--;
        
        if (this.k == 0)
        {
            result = root.val;
            return;
        }
        
        kthSmallestHelper(root.right);
    }
}
