// time complexity: on(n)
// space complexity: o(1)
// idea: Do an inorder traversal and find kth element while traversing
// did it run on leetcode: yes
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int res = 0;
    public int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        result(root, k, 0);
        return res;
    }
    
    public void result(TreeNode node, int k, int r) {
        if(node == null) return;
        result(node.left, k, r);
        count++;
        if(count==k) res = node.val;
        result(node.right, k, r);
    }
}