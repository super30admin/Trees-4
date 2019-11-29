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
       
        private int result;
 private int count=0;
    public int kthSmallest(TreeNode root, int k) {
   
        Inorder(root,k);
            return result;
        
    }
    
    private void Inorder(TreeNode root, int k)
    {
        if(root==null) return;
        Inorder(root.left,k);
        count++;
        if(count==k) result=root.val;
        Inorder(root.right,k);
        
        
    }
}
