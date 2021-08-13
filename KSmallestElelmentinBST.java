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
class Solution {
    int x=0, value;
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        inorderTraversal(root,k);
        return value;
    }
    public void inorderTraversal(TreeNode root, int k) {

        if(root == null)
            return;

        inorderTraversal(root.left,k);

        if(++x == k ){
            value=root.val;
            return;
        }
        inorderTraversal(root.right,k);
    }
}