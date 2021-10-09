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
// Idea here is to recursively perform inorder traversal and add it to a list. Return kth value as it will be sorted now
class Solution {
    int kth = -1;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        ArrayList<Integer> arr = helper(root, new ArrayList<>());
        return arr.get(k-1);
    }
    
    public ArrayList<Integer> helper(TreeNode root, ArrayList<Integer> arr) {
        if(root==null) return arr;
        helper(root.left, arr);
        arr.add(root.val);
        helper(root.right, arr);
        return arr;
    }
}