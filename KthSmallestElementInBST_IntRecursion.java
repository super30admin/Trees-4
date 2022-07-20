/* Time Complexity: O(n)
 * Space Complexity: O(h)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

import java.util.ArrayList;
import java.util.List;

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
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        return inorder(root);
    }
    public int inorder(TreeNode root){
        //base
        if(root == null) return Integer.MAX_VALUE;
        //logic
        int left = inorder(root.left);
        if(left != Integer.MAX_VALUE) return left;
        count--;
        if(count == 0){
            return root.val;
        }
        return inorder(root.right);
    }
}