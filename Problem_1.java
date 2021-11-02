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
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// create a stack, add to the stack until the left is not null, then pop form stack and reduce the counter, if counter get to 0 then its done, else at the end visit the right node.
// Your code here along with comments explaining your approach
// bfs using stack
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while( !st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if( k == 0 ) return root.val;
            root = root.right;
        }
        return -1;
    }
}
// dfs
// class Solution {
//     int value;
//     int count;
//     public int kthSmallest(TreeNode root, int k) {
//         value = 0;
//         count = k;
//         helper(root);
//         return value;
//     }
//     private void helper(TreeNode root){
//         // base
//         if(root == null) return;
//         // logic
//         helper(root.left);
//         count--;
//         if(count == 0) value = root.val;
//         helper(root.right);
//     }
// }