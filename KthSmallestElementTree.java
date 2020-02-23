//Time Complexity: O(k) where k is smallest element number
//Space Complexity: O(h) where h is height of tree

import java.util.Stack;

public class KthSmallestElementTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		if (root == null)
			return -1;
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
