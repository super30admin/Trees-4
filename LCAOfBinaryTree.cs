using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    public class LCAOfBinaryTree
    {
        /*
         * T.C: O(n) need to traverse all the element in the tree
         * S.C: O(h) h is hight of tree
         */
        List<TreeNode> treenodep;
        List<TreeNode> treenodeq;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
        {
            treenodep = new List<TreeNode>();
            treenodeq = new List<TreeNode>();

            backtracking(root, p, q, new List<TreeNode>());

            for (int i = 0; i < treenodep.Count; i++)
            {
                if (treenodep[i].val != treenodeq[i].val)
                {
                    return treenodep[i - 1];
                }
            }

            return null;
        }

        public void backtracking(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path)
        {
            //base
            if (root == null)
                return;

            //logic
            path.Add(root);
            if (root.val == p.val)
            {
                treenodep=new List<TreeNode>(path);
                treenodep.Add(root);
            }
            else if (root.val == q.val)
            {
                treenodeq=new List<TreeNode>(path);
                treenodeq.Add(root);
            }

            //recurse
            backtracking(root.left, p, q, path);
            backtracking(root.right, p, q, path);

            //backtrack
            path.RemoveAt(path.Count - 1);
        }


        //Method 2: bottom up approch
        public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
        {
            if (root == null || root == p || root == q)
            {
                return null;
            }

            TreeNode left = LowestCommonAncestor(root.left, p, q);
            TreeNode right = LowestCommonAncestor(root.right, p, q);

            if (left == null && right == null)
                return null;
            else if (left != null && right == null)
                return left;
            else if (right != null && left == null)
                return right;
            else
                return root;

        }
    }
}
