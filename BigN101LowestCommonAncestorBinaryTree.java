// Time complexity is O(n)
// Space complexity is O(h)
// This solution is submitted on leetcode

public class BigN101LowestCommonAncestorBinaryTree {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class Solution {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			// base case
			if (root == null || root.val == p.val || root.val == q.val)
				return root;
			// logic
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			TreeNode right = lowestCommonAncestor(root.right, p, q);
			if (left != null && right != null)
				return root;
			if (left != null)
				return left;
			if (right != null)
				return right;
			else
				return null; 
		}
	}
}