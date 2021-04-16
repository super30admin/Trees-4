// Time Complexity : O(h+k) h - height of the tree and k - k smallest element, Max h and min k
// Space Complexity : O(h) where h - height of the tree (stack size)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k == 0)
                return root.val;
            root = root.right;
        }
        return -1;
    }
}
