import java.util.*;

public class CommonAncestor {
	//	Time:  O(n) 
	//	Space O(1) 
	//	LeetCode: yes

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//base
		if(root == null|| root == p || root == q) return root;
		//logic
		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		// case1
		if(left != null && right != null) return root;
		//case2
		else if(left != null ) return left;
		//case3
		else if(right != null ) return right;
		//case4
		else return null;
	}
}