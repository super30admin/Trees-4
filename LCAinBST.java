// Time Complexity : O(log n) n = number of nodes
// Space Complexity : constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//iterative solution
//we just keep going down in the tree, nothing comes out of the stack, so we actually dont need the stack

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while(true)
        {
            //if both are smaller, go left
            if(root.val > p.val && root.val > q.val)
                root = root.left;

            //if both larger, go right
            else if(root.val < p.val && root.val < q.val)
                root = root.right;

            //if p or q is root or root lies between p and q
            else
                return root;
        }
    }
}
