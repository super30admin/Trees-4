// Time Complexity :O(k)
// Space Complexity :height of tree(recursive space)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    private int counter;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        counter = 0;
        inorder(root, k);
        return result;
    }

    public void inorder(TreeNode root, int k) {
        // edge
        if (root == null)
            return;
        // logic
        inorder(root.left, k);
        // if we are at kth element, make it result
        if (counter == k - 1)
            result = root.val;
        counter++;
        inorder(root.right, k);
    }
}