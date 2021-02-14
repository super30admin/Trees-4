// Time Complexity : O(n)
// Space Complexity : O(1) in Iterative approach, O(h) in recursive
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//If p & q both are smaller than the root, then they must be present in the left subtree of the root.
//If p & q both are greater than the root, then they must be present in the right subtree of the root.


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

       while(true) {
            if(p.val < root.val && q.val < root.val) root = root.left;
            else if(p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
    }


}
