
// Time Complexity : O(n)
// Space Complexity : O(H) -> recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
    int count, answer;
    public int kthSmallest(TreeNode root, int k) {

        if(root == null){
            return -1;
        }

        answer = -1;
        count = k;

        recurse(root);

        return answer;
        
    }

    private void recurse(TreeNode root){

        if(root == null){
            return;
        }

        recurse(root.left);
        count--;
        if(count == 0){
            answer = root.val;
        }
        recurse(root.right);
    }
}