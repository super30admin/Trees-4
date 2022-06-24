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
// time - O(n)
//space - O(h)
class Solution {
    int count =0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        int left = kthSmallest(root.left, k);
        count ++;
        if(count ==k){
            return root.val;
        }
        int right = kthSmallest(root.right, k);
        return left+right;
    }
}