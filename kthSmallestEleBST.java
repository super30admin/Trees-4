// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We do an inorder traversal and keep track of a count var
// Return result when count = k

class Solution {
    int count = 0;
    TreeNode res;
    public int kthSmallest(TreeNode root, int k) {     
        inorder(root, k);
        return res.val;
    }
    private void inorder(TreeNode root, int k){
        if(root == null)
            return;
        if(count<k)
            inorder(root.left,k);
        count++;
        if(count == k) {
            res = new TreeNode(root.val);
        }
        if(count<k)
            inorder(root.right, k);
    }
}