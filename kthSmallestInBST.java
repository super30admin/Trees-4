// Time Complexity : O(n) n = number of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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


//using inorder traversal

class Solution {

    int count;
    int result;

    public int kthSmallest(TreeNode root, int k) {

        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k)
    {
        //base
        if(root == null)
            return;

        //logic
        inorder(root.left, k);
        //st.pop();
        count++;
        if(count == k)
        {
            result = root.val;
            return;
        }

        inorder(root.right, k);
    }
}
