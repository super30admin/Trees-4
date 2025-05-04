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
    int count =0;
    TreeNode res;
    public int kthSmallest(TreeNode root, int k) {
        this.count = 0;
        helper(root, k);
        return res.val;
    }

    private void helper(TreeNode root, int k){
        if(root == null)
            return;
        
        //
        helper(root.left, k);
        count++;
        if(count == k)
            res = root;
        helper(root.right, k);
    }
}