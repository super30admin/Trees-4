/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    
    int x;
    
    public int KthSmallest(TreeNode root, int k) {
        
        x = k;
        return Helper(root, k);
    }
    
    private int Helper(TreeNode root, int k) {
        
        if(root == null) {
            return Int32.MaxValue;
        }
        
        int l = Helper(root.left, k);
       
        x--;
        
        if(x == 0) {
            return root.val;
        }
        
        int r = Helper(root.right, x);
        
        return Math.Min(l, r);
    }
    
}