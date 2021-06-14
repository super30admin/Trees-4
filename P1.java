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
//time- o(n)
//space - const
class Solution {
    int result;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
      
        return result;
    }
    
    public void inorder(TreeNode node)
    {
        //base
        if(node == null) return; //1
        //recurse
        
        inorder(node.left);//null
        
        k--;
        
        if(k == 0 ){
            result = node.val;
            return;
        }
        
        inorder(node.right);
        
    }
}