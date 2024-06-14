// Time Complexity : O(N)
// Space Complexity : O(H) or recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
        this.count=0;
        helper(root,k);
        return result.val;
    }

    private void helper(TreeNode root, int k) {
        // base
        if(root == null) return;

        if(result == null)
            helper(root.left,k);
        count++;
        if(count == k) {
            this.result = root;
        }

        if(result == null)
            helper(root.right,k);
    }
}


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
        Stack<TreeNode> st= new Stack<>();

        while(!st.isEmpty() || root != null) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;

            if(k ==0){
                return root.val;
            }
            root = root.right;
        }

        return -1;
    }
}