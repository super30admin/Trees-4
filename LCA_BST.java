// Time Complexity : O(H)
// Space Complexity : Recursive O(H) or Iterative O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


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

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q);
        // if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left,p,q);
        // return root;
        while(root!= null){
            if(p.val > root.val && q.val > root.val) root = root.right;
            else if(p.val < root.val && q.val < root.val) root = root.left;
            else return root;
        }
        return root;
        
    }
}
