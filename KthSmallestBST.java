//TC: SC: O(n)

import javax.swing.tree.TreeNode;

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
    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
        this.count = 0;
        helper(root, k);
        return result.val;
    }
    private void helper(TreeNode root, int k){

        if(root == null || result != null) return;

        if(result == null){
            helper(root.left, k);
        }

        //INORDER
        count++;
        if(count == k){ //conditional recursion to avoid unnecssary traversal after finding the kth smallest
            result = root;
        }

         if(result == null){ //conditional recursion to avoid unnecssary traversal after finding the kth smallest
            helper(root.right, k);
        }

    }
}