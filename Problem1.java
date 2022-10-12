// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


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
class Problem1 {

    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {

        count = k;
        inOrder(root);
        return result;


    }
    private void inOrder(TreeNode root){

        if(root == null) return;

        //logic
        inOrder(root.left);
        count--;

        if(count ==0){
            result = root.val;
        }

        inOrder(root.right);
    }
}