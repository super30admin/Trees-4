 public class LowestCommonAncestorBT
    {
        // Time Complexity : O(n), n nodes
        // Space Complexity : O(h) - recursive stack space and the 2 list for pathp and pathq
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        List<TreeNode> pathP;
        List<TreeNode> pathQ;
        public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
        {
            if (root == null) return null;
            backtrack(root, p, q, new List<TreeNode>());
            for (int i = 0; i < pathP.Count; i++)
            {
                if (pathP[i].val != pathQ[i].val)
                {
                    return pathP[i - 1];
                }
            }
            return null;
        }

        private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path)
        {
            //base
            if (root == null)
                return;
            //logic
            //action
            path.Add(root);

            if (root == p)
            {
                pathP = new List<TreeNode>(path);
                pathP.Add(p);
            }
            if (root == q)
            {
                pathQ = new List<TreeNode>(path);
                pathQ.Add(q);
            }

            //recurse
            if (pathP == null || pathQ == null)
            {
                backtrack(root.left, p, q, path);
            }
            if (pathP == null || pathQ == null)
            {
                backtrack(root.right, p, q, path);
            }

            //backtrack
            path.RemoveAt(path.Count - 1);
        }
 }
