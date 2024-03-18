
//TC- O(n)
//SC -O(h)
import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Solution {
	List<TreeNode> pathP;
	List<TreeNode> pathQ;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		helper(root, p, q, new ArrayList<>());
		for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
			if (pathP.get(i) != pathQ.get(i))
				return pathP.get(i - 1);
		}
		return null;
	}

	private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
		// base
		if (root == null)
			return;
		path.add(root);
		if (root == p) {
			pathP = new ArrayList<>(path);
			pathP.add(p);
		}
		if (root == q) {
			pathQ = new ArrayList<>(path);
			pathQ.add(q);
		}
		// logic
		// action
		helper(root.left, p, q, path);
		if (pathP == null || pathQ == null)
			helper(root.right, p, q, path);
		// backtrack
		path.remove(path.size() - 1);

	}
}

public class LowestCommonAncestor_BinaryTree {

	public static void main(String[] args) {
		// Creating tree nodes
		TreeNode node3 = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node0 = new TreeNode(0);
		TreeNode node8 = new TreeNode(8);
		TreeNode node7 = new TreeNode(7);
		TreeNode node4 = new TreeNode(4);

		// Constructing the tree
		node3.left = node5;
		node3.right = node1;
		node5.left = node6;
		node5.right = node2;
		node1.left = node0;
		node1.right = node8;
		node2.left = node7;
		node2.right = node4;

		Solution solution = new Solution();

		// Specify the nodes p and q
		TreeNode p = node5;
		TreeNode q = node1;

		// Finding lowest common ancestor
		TreeNode lca = solution.lowestCommonAncestor(node3, p, q);

		// Displaying the value of lowest common ancestor
		System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
	}
}
