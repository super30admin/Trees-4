// TC: O(n)
// SC: O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int count = 0;
    int res = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }
    
    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
        }
        if (count < k) {
            inorder(root.right, k);
        }
    }
}
