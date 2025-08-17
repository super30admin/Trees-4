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
    public int kthSmallest(TreeNode root, int k) {

        if(root == null){
            return -1;
        }

        int answer = -1;

        Stack<TreeNode> s = new Stack<>();

        while(answer == -1){

            //move left
            while(root != null){
                s.add(root);
                root = root.left;
            }

            root = s.pop();
            k--;
            if(k == 0){
                answer = root.val;
            }
            
            root = root.right;
        
        }

        return answer;
        
    }
}