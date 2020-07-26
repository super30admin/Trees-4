//TC - O(N)
//SC - O(H)
class Solution4 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// base
		if (root == null || p.val == root.val || q.val == root.val)
			return root;

		// logic
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		else if (left != null)
			return left;
		else if (right != null)
			return right;
		else
			return null;
	}
}