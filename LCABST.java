// Time Complexity : 0(n) where n is total no of nodes
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LCABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(root.val>p.val && root.val>q.val)
                root = root.left;
            else if(root.val<p.val && root.val<q.val)
                root = root.right;
            else
                return root;
        }
    }
}