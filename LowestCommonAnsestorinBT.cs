using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity : O(n)
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  Referred Online
    public class LowestCommonAnsestorinBT
    {
        List<TreeNode> path1;
        List<TreeNode> path2;
        public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
        {
            if (root == null || root.val == p.val || root.val == q.val) return root;
            backtrack(root, p, q, new List<TreeNode>());

            for (int i = 0; i < path1.Count; i++)
            {
                if (path1[i].val != path2[i].val)
                {
                    return path1[i - 1]; // return previous node
                }
            }
            return null;
        }

        private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path)
        {
            //base
            if (root == null) return;

            //logic

            //action
            path.Add(root);
            if (root == p)
            {
                path1 = new List<TreeNode>(path);
                path1.Add(p);
            }
            if (root == q)
            {
                path2 = new List<TreeNode>(path);
                path2.Add(q);
            }
            //recurse
            backtrack(root.left, p, q, path);
            //st.pop();
            backtrack(root.right, p, q, path);
            //back track
            path.RemoveAt(path.Count - 1);
        }
    }
}
