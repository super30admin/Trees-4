//Time complexity= O(logn)
//Space complexity=O(1)
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
        while(root != null){
           if(p.val < root.val && q.val < root.val)root = root.left;
            else if(p.val > root.val && q.val > root.val) root = root.right;
            else return root; 
        }
        return null;
        
    }
}