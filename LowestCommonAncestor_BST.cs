using System;
namespace Algorithms
{
    public class LowestCommonAncestor_BST
    {
        /// Time Complexity : O(n)
        // Space Complexity :O(n)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        public TreeNode LowestCommonAncestor_Recursion(TreeNode root, TreeNode p, TreeNode q)
        {
            if (p.val < root.val && q.val < root.val) return LowestCommonAncestor_Recursion(root.left, p, q);
            else if (p.val > root.val && q.val > root.val) return LowestCommonAncestor_Recursion(root.right, p, q);
            return root;
        }

        /// Time Complexity : O(n)
        // Space Complexity :O(1)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        public TreeNode LowestCommonAncestor_Iterative(TreeNode root, TreeNode p, TreeNode q)
        {
            while (true)
            {
                if (p.val < root.val && q.val < root.val) root = root.left;
                else if (p.val > root.val && q.val > root.val) root = root.right;
                else return root;
            }
        }
    }
}
