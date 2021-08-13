// Time Complexity : O(n), n -> Number of nodes in the tree
// Space Complexity : O(log n), log n -> Size of recursive stack, Size of paths
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorBinaryTree {
	List<TreeNode> pPath;
	List<TreeNode> qPath;

	/********************* Recursion *********************/
	// Time Complexity : O(n), n -> Number of nodes in the tree
	// Space Complexity : O(log n), log n -> Size of recursive stack, Size of paths
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}

		pPath = new ArrayList<TreeNode>();
		qPath = new ArrayList<TreeNode>();

		backtrack(root, p, q, new ArrayList<>());

		for (int i = 0; i < pPath.size(); i++) {
			if (pPath.get(i) != qPath.get(i)) {
				return pPath.get(i - 1);
			}
		}

		return null;
	}

	private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
		// Base
		if (root == null) {
			return;
		}

		if (root == p) {
			pPath = new ArrayList<>(path);
			pPath.add(p);
			pPath.add(p);
		}

		if (root == q) {
			qPath = new ArrayList<>(path);
			qPath.add(q);
			qPath.add(q);
		}

		// Logic
		path.add(root);
		backtrack(root.left, p, q, path);
		if (pPath.size() == 0 || qPath.size() == 0) {
			backtrack(root.right, p, q, path);
		}
		path.remove(path.size() - 1);
	}

	/********************* Bottom Up Recursion *********************/
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		} else if (left != null) {
			return left;
		} else if (right != null) {
			return right;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		LowestCommonAncestorBinaryTree obj = new LowestCommonAncestorBinaryTree();
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
		TreeNode q = root.left.right;

		System.out.println("Lowest Common Ancestor of \'" + p.val + "\' and \'" + q.val + "\' is \'"
				+ obj.lowestCommonAncestor(root, p, q).val + "\'");
	}

}
