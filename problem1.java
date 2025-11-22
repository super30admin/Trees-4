// Time Complexity :O(k)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
we are using recursion to traverse all the node,
we will use inorder traversal,
keep track on how much elements we have seen and when that reaches the value k return.
*/
class Solution {
    Integer result;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result;
    }

    private void helper(TreeNode root, int k) {
        if (root == null || result != null)
            return;

        helper(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
        }
        helper(root.right, k);
    }
}