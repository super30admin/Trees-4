//Time complexity is O(logn)
// Space complexity is O(logn)
// This solution is submitted on leetcode

public class BigN100LowestCommonAncestorRecursive {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class Solution {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			// base case or edge case
			if (root == null)
				return null;
			// logic
			if (p.val < root.val && q.val < root.val)
				return lowestCommonAncestor(root.left, p, q);
			else if (p.val > root.val && q.val > root.val)
				return lowestCommonAncestor(root.right, p, q);
			else
				return root;
		}
	}
}