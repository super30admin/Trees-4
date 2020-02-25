//Time complexity is O(k)
//Space complexity is O(n)
//This solution is submitted on leetcode

import java.util.Stack;

public class BigN99KthSmallestElementInBinaryTreeIterative {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class Solution {
		public int kthSmallest(TreeNode root, int k) {
			// edge case
			if (root == null)
				return 0;
			Stack<TreeNode> st = new Stack<>();
			while (root != null || !st.isEmpty()) {
				while (root != null) {
					st.push(root);
					root = root.left;
				}
				root = st.pop();
				k--;
				if (k == 0)
					return root.val;
				root = root.right;
			}
			return -1;
		}
	}
}