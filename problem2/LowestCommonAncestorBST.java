// Time Complexity : O(log n), n -> Number of nodes in the tree, log n -> Height of Tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class LowestCommonAncestorBST {
	/********************* Recursive Approach *********************/
	// Time Complexity : O(log n), n -> Number of nodes in the tree, log n -> Height of Tree
	// Space Complexity : O(log n), log n -> Size of recursive stack
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}

		if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}
	}

	/********************* Iterative Approach *********************/
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}

		TreeNode node = root;

		while (node != null) {
			if (p.val > node.val && q.val > node.val) {
				node = node.right;
			} else if (p.val < node.val && q.val < node.val) {
				node = node.left;
			} else {
				return node;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		LowestCommonAncestorBST obj = new LowestCommonAncestorBST();
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);

		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);

		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		TreeNode p = root.left;
		TreeNode q = root.right;

		System.out.println("Lowest Common Ancestor of \'" + p.val + "\' and \'" + q.val + "\' is \'"
				+ obj.lowestCommonAncestor(root, p, q).val + "\'");
	}

}
