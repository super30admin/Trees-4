// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
    //List<Integer> result;
    int value;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count=0;
        dfs(root,k);
        return value;
    }
    
    public void dfs(TreeNode node,int k){
        if(node==null){
            return;
        }
        dfs(node.left,k);
        count=count+1;
        if(count==k){
            value=node.val;
        }
        dfs(node.right,k);
    }
}