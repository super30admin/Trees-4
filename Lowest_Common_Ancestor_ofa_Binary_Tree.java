import java.util.*;
/**********************************Using Recursion************************************/
//Time Complexity :O(n), no of nodes in tree
//Space Complexity :O(h), height of tree
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

/**Recursively call inorder traversal on left and right node of the tree 
 * if the left and right node found, matches to p and q, return that root node.
 * Else keep traversing of left of the tree and right of the tree.
 * **/
public class Lowest_Common_Ancestor_ofa_Binary_Tree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root== null || root == p || root == q)
			return root;

		//recursively calling inorder traversal
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p , q);

		if(left==null) return right;
		if(right==null) return left;

		return root;

	}
}
/**********************************Using Backtracking************************************/
//Time Complexity :O(n), no of nodes in tree
//Space Complexity :O(h), height of tree
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

class Lowest_Common_Ancestor_ofa_Binary_Tree_Backtrack {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> path1 = new ArrayList<>();
		List<TreeNode> path2 = new ArrayList<>();

		backtrack(root, p, path1);
		backtrack(root, q, path2);

		for(int i=0; i<path1.size(); i++){
			if(path1.get(i) != path2.get(i))
				return path2.get(i-1);
		}
		return null;
	}

	private void backtrack(TreeNode root, TreeNode p, List<TreeNode> path){
		//base
		if(root == p)
			path.add(root);

		//logic
		//action
		if(root != null){
			path.add(root);
			//recurse
			backtrack(root.left, p, path);
			if(path.get(path.size()-1) == p)
				return;

			backtrack(root.right, p, path);
			if(path.get(path.size()-1) == p)
				return;

			//backtrack
			path.remove(path.size()-1);
		}
	}
}