// Time Complexity : O(n), n = number of nodes
// Space Complexity : O(H), H = Height of the tree
// Did this code successfully run on Leetcode : Yes

class Solution {
    int count, result;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;
        inorder(root, k);
        return result;
    }
    private void inorder(TreeNode root, int k) {
        if(root == null)
            return;
        inorder(root.left, k);
        if(++count == k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);      
    }
}