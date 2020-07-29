//Time complexity=O(h-1) or O(logn)
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
        
        //logic
        if(p.val < root.val && q.val < root.val)return lowestCommonAncestor(root.left, p, q);
        else if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}