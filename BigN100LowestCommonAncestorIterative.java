//Time complexity is O(logn)
//Space complexity is O(1)
//This solution is submitted on leetcode

public class BigN100LowestCommonAncestorIterative {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class Solution {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			while (root != null) {
				if (p.val < root.val && q.val < root.val)
					root = root.left;
				else if (p.val > root.val && q.val > root.val)
					root = root.right;
				else
					return root;
			}
			return null;
		}
	}
}