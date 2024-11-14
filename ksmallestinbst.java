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
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        count=0;
        dfs(root,k);
        return result;
    }
    private void dfs(TreeNode root, int k){
        
        if(root.left!=null){
            dfs(root.left,k);
        }
        count++;
        if(count==k){
            result = root.val;
            return;
        }
        
        if (root.right!=null){
            dfs(root.right,k);
        }
        return;
    }
}
