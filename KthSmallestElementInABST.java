// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    
    private List<Integer> bst = new ArrayList();
    
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null)    return 0;
        
        inOrder(root);

        return bst.get(k - 1);
        
    }
    
    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        
        inOrder(root.left);
        
        bst.add(root.val);
        
        inOrder(root.right);
        
        
    }
}
