// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

class Solution {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        result = -1;
        count = k;
        inorder(root);
        return result;
    }
    void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        count--;
        if(count == 0){
            result = root.val;
            return;
        }
        inorder(root.right);
    }
}