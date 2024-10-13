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

// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

public class Problem {
      int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        this.res = 0;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        //logic
        inorder(root.left);
        //visit
        count --;
        if(count == 0){
            res = root.val;
        }
        //conditional recursion
        if(count !=0){
            inorder(root.right);
        }
    }   
    
}
