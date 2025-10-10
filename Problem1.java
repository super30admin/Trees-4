// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//We perform inorder traversal and increase count while visiting each node
//When count becomes equal to val k we return the root val

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
    int count = 0;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res;
        
    }

    private void helper(TreeNode root, int k) {
        //base
        if(root == null) return;

        //logic
        helper(root.left, k);

        count++;
        if(count == k) {
            res = root.val;
        }

        helper(root.right, k);
    }
}
