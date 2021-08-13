// Time Complexity : O(n), n -> Number of nodes in the tree
// Space Complexity : O(log n), log n -> Height of Tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class KthSmallestElementBST {
	int result;
	int cnt;

	/********************* Inorder Traversal - Recursive *********************/
	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return -1;
		}

		cnt = 0;

		getInorder(root, k);
		return result;
	}

	private void getInorder(TreeNode root, int k) {
		if (root == null) {
			return;
		}

		getInorder(root.left, k);
		cnt++;
		if (cnt == k) {
			result = root.val;
			return;
		}
		getInorder(root.right, k);
	}

	public static void main(String[] args) {
		KthSmallestElementBST obj = new KthSmallestElementBST();

		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);

		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);

		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		int k = 4;

		System.out.println("Smallest element number \'" + k + "\' = " + obj.kthSmallest(root, k));
	}

}
