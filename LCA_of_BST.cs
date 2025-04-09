/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
// time complexity - O(h)
// space complexity - O(1) for iterative approach, O(h) for recursive
public class Solution
{
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        // iterative approach
        while (root != null)
        {
            if (p.val < root.val && q.val < root.val)
            {
                root = root.left;
            }
            else if (p.val > root.val && q.val > root.val)
            {
                root = root.right;
            }
            else
            {
                return root;
            }
        }
        return null;
        // recursive approach
        // if(root == null)
        // {
        //     return null;
        // }
        // if(p.val < root.val && q.val < root.val)
        // {
        //     return LowestCommonAncestor(root.left,p,q);
        // }
        // else if(p.val>root.val && q.val>root.val)
        // {
        //     return LowestCommonAncestor(root.right,p,q);
        // }
        // else
        // {
        //     return root;
        // }
    }
}