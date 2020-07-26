//TC - O(N)
//SC - o(H)
class Solution1 {
	int count;
	int result;

	public int kthSmallest(TreeNode root, int k) {
		count = k;
		inorder(root);
		return result;
	}

	public void inorder(TreeNode root) {
		// base
		if (root == null) {
			return;
		}
		// logic
		inorder(root.left);
		count--;
		if (count == 0) {
			result = root.val;
			return;
		}
		inorder(root.right);
	}
}