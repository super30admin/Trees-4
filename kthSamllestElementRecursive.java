//TC : O(n) where n is the number of nodes
//SC : O(h) where h is height of the tree , counting the recursive stack memory
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
    int result = -1;
    int count ;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        
        return result;
    }
    
    
    private void inorder(TreeNode root){
        if(root==null) return;
        
        inorder(root.left);
        count--;
        if(count == 0)
            result = root.val;
        inorder(root.right);
        
        
    }
        
        
}