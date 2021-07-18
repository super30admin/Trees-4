//Time Complexity : O(n) 
//Space Complexity :O(1) 
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

/*
 * 1. use BST property. Find node which is in between the given numbers.
 * 2. if the given values are one each side fo the node thats the LCA in BST.
 */

public class BSTLCA {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode result = null;

		while (result == null) {
			if (p.val > root.val && q.val > root.val) {
				root = root.right;
			} else if (p.val < root.val && q.val < root.val) {
				root = root.left;
			} else {
				result = root;
			}
		}

		return result;
	}

}
