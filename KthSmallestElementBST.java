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
    //Time Complexity:O(n)
    //Space Complexity:O(h) stack height
    int count,res = Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null){
            return 0;
        }
        // Queue<TreeNode> q = new LinkedList<>();
        //let's do an in order traversal
        count =k;
        dfs (root);
        // intQlen = q.size();
        return res;
    }

    private void dfs (TreeNode root){
            if (root == null || res != Integer.MIN_VALUE){
                return;
            }
        dfs (root.left);
        count--;
        if (count == 0)
        res = root.val;
        dfs (root.right);
    }
}
