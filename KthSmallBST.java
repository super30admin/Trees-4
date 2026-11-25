/**
 * Time Complexity:  O(n)  where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree
 */

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
    int counter = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;

    }

    void dfs(TreeNode node, int k){
        if(node.left!=null){
            dfs(node.left, k);
        }
        counter++;
        if(counter == k){
            result = node.val;
        }
        if(node.right!=null){
            dfs(node.right, k);
        }
    }
}