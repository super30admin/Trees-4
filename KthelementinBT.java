
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
 *
 * TC --> O(n)
 * SC --> O(h)
 */
class Solution {

    int[] val;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        val = new int[1];
        val[0] = k;
        dfs(root, val);
        System.out.print(res);
        return res;

    }

    public void dfs(TreeNode root, int[] val) {
        if (root != null) {
            dfs(root.left, val);
            val[0] -= 1;
            if (val[0] == 0) {
                res = root.val;
                return;
            }
            if (val[0] != 0) {
                dfs(root.right, val);
            }

        }//if
    }//method
}//class
