import java.util.Stack;

// Time Complexity : O(N) in worst case when k = N
// Space Complexity : O(H) H is the depth of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Take a stack and push the root. Then traverse to the left until null is found
 * and push these nodes to the stack. Once null is hit, then pop an element from
 * the stack and decrement k and check if k = 0, if so return the popped element
 * else push that element's right to the stack. This happens until k becomes 0.
 *
 */
class Solution {
	public int kthSmallest(TreeNode root, int k) {
		if (root == null)
			return -1;
		Stack<TreeNode> stack = new Stack<>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();
			if (--k == 0)
				return root.val;
			root = root.right;
		}
	}
}