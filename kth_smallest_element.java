// TC: O(k) in best case and O(n) if n == k
// SC: O(k) if k is small enough that we dont go till max height otherwise O(h) where h is the height of the tree

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
    // List<Integer> result;
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        result = 0;
        dfs(root, k);
        return result;
    }

    public void dfs(TreeNode root, int k){
        if(root == null){
            return;
        }
        dfs(root.left, k);
        count++;
        if(count == k){
            result = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
