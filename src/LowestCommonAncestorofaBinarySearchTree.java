

public class LowestCommonAncestorofaBinarySearchTree {

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

		// base
		if (root == null)
			return root;

		// logic

		if (p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		if (p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);

		return root;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
