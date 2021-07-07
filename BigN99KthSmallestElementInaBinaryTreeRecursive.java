// Time complexity is O(k)
// Space complexity is O(height)
// This solution is submitted on leetcode

public class BigN99KthSmallestElementInaBinaryTreeRecursive {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class Solution {
		int count;
		int res;

		public int kthSmallest(TreeNode root, int k) {
			// edge case
			if (root == null)
				return 0;
			count = k;
			res = -1;
			inorder(root);
			return res;
		}
		private void inorder(TreeNode root) {
			// base case
			if (root == null)
				return;
			// logic
			inorder(root.left);
			count--;
			if (count == 0) {
				res = root.val;
				return;
			}
			inorder(root.right);
		}
	}
}