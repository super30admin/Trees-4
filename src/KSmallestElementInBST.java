// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 * 
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

/* O(n) time O(h) space inorder traversal solution, using principal that
inorder traversal is always sorted
*/
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> st = new Stack<>();
        
        while(root != null || !st.isEmpty()){
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            
            root = st.pop();
            k--;
            
            if( k == 0){
                return root.val;
            }
            
            root = root.right;
        }
        
        return -1;
    }
}