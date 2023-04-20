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
    // global variables to store count and result
    int count ;
    int result;
    Boolean flag;
    public int kthSmallest(TreeNode root, int k) {
        // TC-O(N),SC-O(h)
        // DO INORDER TRAVSERSAL and reduce count by one each, when count becomes zero, that is the solution
        // initialise count to k and flag to false
        count = k;
        flag = false;
        helper(root, k);
        return result;
    }
     public void helper(TreeNode root,int k){
            if (root==null) return ;
            // left traversal 
            helper(root.left,k);
            // on current node, decrease count and check if its zero and set result and flag
            count -= 1;
            if(count==0 && flag == false){
                flag = true;
                result = root.val;
            }
            if(flag== false){
                helper(root.right, k);
            }
            return;
        }
}