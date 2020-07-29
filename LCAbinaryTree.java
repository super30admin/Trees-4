//Time complexity=O(n)
//Space complexity=O(h)heigth of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if(root == null || p.val == root.val || q.val == root.val)return root;
        
        //logic
        TreeNode left = lowestCommonAncestor(root.left , p, q);
        TreeNode right = lowestCommonAncestor(root.right , p, q);
        if(left !=null && right != null)return root;
        else if(left != null)return left;
        else if(right != null)return right;
        return null;
    }
}