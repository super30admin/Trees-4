// Time Complexity: O(lgn)
// Space Complexity: O(1)



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if( p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
}