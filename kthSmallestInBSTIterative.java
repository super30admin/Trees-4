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
// Time : O(n)
// Space: O(h)
// Idea here is to iteratively put nodes into stack until smallest number is reached.
// now all smaller elements are popped 1 by one until kth element is reached
// otherwise right child are visited and added to stack iteratively.
class Solution {
    int kth = -1;
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(true) {
            while(root!=null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            k--;
            if(k==0) {
                return root.val;
            }
            root = root.right;
        }
    }
}