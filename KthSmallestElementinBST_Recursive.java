// Time Complexity : O(n) --> where n is the number of elements in the tree
// Space Complexity : O(h) --> where h is the height of the tree
// Did this code successfully run on Leetcode (230): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

cclass Solution {
    int count; int result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }
    
    private void inorder(TreeNode root) {
        // base case
        if (root == null) return;
        
        // logic
        inorder(root.left);
        count--;
        if (count == 0) {
            result = root.val;
            return;
        }
        inorder(root.right);
    }
}