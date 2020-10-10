/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time Complexity-O(logn)
//Space Complexity-O(1)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
        {
            return root;
        }
        while(root!=null)
        {
            if(p.val>root.val && q.val>root.val)
            {
                root=root.right;
            }
            else if(p.val<root.val && q.val<root.val)
            {
                root=root.left;
            }
            else{
                return root;
            }
        }
        return root;
    }
}