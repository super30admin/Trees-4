//Time Complexity : O(n)  
//Space Complexity :O(h) //stack will hold at max high of the tree elements 
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

/*
 * 1. As it is the BST tree inorder traversal will give the elements in order.
 * 2 Do inorder and find kth element.
 */
public class KthsmallestBST {
	int result, count;

	public int kthSmallest(TreeNode root, int k) {
		count = 0;
		result = -1;
		inorder(root, k);
		return result;
	}

	private void inorder(TreeNode root, int k) {
		if (root == null)
			return;
		if (result == -1)
			inorder(root.left, k);
		// pop here
		count++;
		if (count == k) {
			result = root.val;
		}
		if (result == -1)
			inorder(root.right, k);

	}

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
}
