// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) to store nodes in the list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class kthSmallestInBST_BruteForce {
    
    List<Integer> list = new ArrayList<>();
    
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return list.get(k-1);
    }
    
    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
}