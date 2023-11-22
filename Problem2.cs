public class LowestCommonAncestorBST
	{
        // Time Complexity : O(h), h is the depth of the tree
        // Space Complexity : O(h) - recursive stack space
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
        {
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
