/*
  Time complexity: O(h)
  Space complexity: O(1)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while(root!=null)
        {
            if(root.val>p.val && root.val>q.val)
                root = root.left;
            else
            if(root.val<p.val && root.val<q.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }
}
