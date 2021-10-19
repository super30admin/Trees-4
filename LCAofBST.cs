using System;
using System.Collections.Generic;
using System.Text;

namespace Tree
{
    class LCAofBST
    {
        public class TreeNode
        {
            internal int val;
            internal TreeNode left;
            internal TreeNode right;
            TreeNode(int x) { val = x; }
        }
        //TC: O(n)
        //SC:O(H)
        public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
        {
            if (root == null)
            {
                return root;
            }
            if (root.val > p.val && root.val > q.val)
            {
                return LowestCommonAncestor(root.left, p, q);
            }
            else if (root.val < p.val && root.val < q.val)
            {
                return LowestCommonAncestor(root.right, p, q);
            }
            else
            {
                return root;
            }
        } 
    }
}
