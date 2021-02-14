import java.util.ArrayList;
import java.util.List;

/*
 * The complexity of the algorithm is O(n) where n is no of elements.
 * Space complexity is O(h) where h is height of tree.
 */

public class LowestCommonAncestorofaBinaryTree {

	// without extra space solution.

	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || root == p || root == q)
			return root;

		TreeNode left = lowestCommonAncestor1(root.left, p, q);
		TreeNode right = lowestCommonAncestor1(root.right, p, q);

		if (left != null && right != null)
			return root;
		else if (left != null)
			return left;
		else if (right != null)
			return right;
		else
			return null;

	}

	// ArrayList solution

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		List<TreeNode> path1 = new ArrayList<>();
		List<TreeNode> path2 = new ArrayList<>();

		backtrack(root, p, path1);
		backtrack(root, q, path2);

		for (int i = 0; i < path1.size(); i++) {

			if (path1.get(i) != path2.get(i)) {

				return path1.get(i - 1);
			}

		}

		return null;
	}

	private void backtrack(TreeNode root, TreeNode p, List<TreeNode> path) {

		// base

		if (root == null)
			return;

		if (root == p) {
			path.add(root);
			path.add(root);
			return;
		}

		// logic

		path.add(root);

		backtrack(root.left, p, path);
		backtrack(root.right, p, path);

		if (path.get(path.size() - 1) == p)
			return;

		path.remove(path.size() - 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
