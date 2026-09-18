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
//Time Complexity: O(n)
//Space Compelxity: O(n)
class Solution {

    private int count = 0, result;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return result;

        Helper(root, k);
        return result;
    }

    public void Helper(TreeNode root, int k){
        //Base Case
        if(root == null) return;

        Helper(root.left, k);
        count++;
        if(count == k){
            result = root.val;
            return;
        }
        Helper(root.right, k);
    }
}