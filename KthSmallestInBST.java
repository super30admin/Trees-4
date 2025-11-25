// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Approach : We perform inorder traversal as we get an ascending order of the BST. We maintain a counter and when it equals k, we return that root value.

class Solution {
    int count;
    Integer result;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k){
        if(root == null){
            return;
        }
        if(result != null){ //conditional check
            return;
        }
        inorder(root.left, k); //left subtree
        count++; //update count
        if(count == k){
            result = root.val;
        }
        inorder(root.right, k); //right subtree
    }
}