/*Running Time Complexity: worst case O(n)
Space Complexity: height of the tree
Successfully Run and Compiled on leetcode
*/
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
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        result = -1;
        inorder(root,k,);
        return result;
    }
    private void inorder(TreeNode root, int k){
        //base 
        if(root == null) {
            return ;
            }
        //logic
        inorder(root.left,k);
        //stack.pop() is happenign here
        count++;
        if(count==k){
            result = root.val;
        }
        System.out.println(root.val);
        if(result == -1){
            inorder(root.right,k);
        }
        
    }
}