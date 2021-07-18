//Time Complexity : O(n) 
//Space Complexity :O(h) 
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

/*
 * 1. 3 possible cases. If p and q are different sides then root is the LCA
 * 2. If p and q found on left side than top node parent is the LCA
 * 3. If p and q found on right side than top node parent is the LCA
 * 
 * Can be done with BFS or DFS. Find two node paths and compare paths and find last common node in the path.
 */

public class BTLCA {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

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

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
