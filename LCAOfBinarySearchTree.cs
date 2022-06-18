using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    public class LCAOfBinarySearchTree
    {
        /*
         * T.C: O(h) where h is hight of tree
         * S.c: O(h)
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
        {

            while (true)
            {
                if (root.val < p.val && root.val < q.val)
                {
                    root = root.right;
                }
                else if (root.val > p.val && root.val > q.val)
                {
                    root = root.left;
                }
                else
                {
                    return root;
                }
            }

        }

        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q)
        {

            if (root.val > p.val && root.val > q.val)
            {
                return lowestCommonAncestor1(root.left, p, q);
            }
            else if (root.val < p.val && root.val < q.val)
            {
                return lowestCommonAncestor1(root.right, p, q);
            }
            else
            {
                return root;
            }


        }
    }
}
