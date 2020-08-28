/**********************************Using Recursion************************************/
// Time Complexity : O(n), if its balanced BST: O(log n)
// Space Complexity : O(h), if its balanced BST: O(log n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**Since its BST
 * If both p and q values are less than root.val, then recurse on root.left
 * if both p and q values are greater than root.val, then recurse on root.right
 * else just return root*/

class Lowest_Common_Ancestor_ofa_Binary_Search_Tree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		else if(p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);
		else
			return root;
	}
}

/**********************************Iterative************************************/
//Time Complexity :O(n), if its balanced BST: O(log n)
//Space Complexity :O(h), if its balanced BST: O(log n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no

class Lowest_Common_Ancestor_ofa_Binary_Search_Tree_Iterative {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while(root != null){
			if(p.val < root.val && q.val < root.val)
				root = root.left;
			else if(p.val > root.val && q.val > root.val)
				root = root.right;
			else
				return root;
		}
		return null;
	}
}