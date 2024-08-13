// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
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
class KthSmallestElementInBST {
    int count;
    int result;
    boolean flag;
    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if(root == null)
            return;
        //recurse left
        inorder(root.left);
        //process root
        count--;
        if(count == 0){
            result = root.val;
            this.flag = true;
        }
        //recurse right
        if(!flag)
            inorder(root.right);
    }
}