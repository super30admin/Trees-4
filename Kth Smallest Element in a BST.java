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

    PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);

    public int kthSmallest(TreeNode root, int k) {

        helper(root,k);

        return q.poll();
    }

    private void helper(TreeNode root, int k)
    {
        if(root == null) return;

        q.add(root.val);
        helper(root.left,k);
        helper(root.right,k);
        if(q.size()>k) q.poll();
    }
}
