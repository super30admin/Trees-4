
public class lcaBT {

	public TreeNode lcaBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root == null)
			return null;
		// if the root value equals any of the p or q values given, return that root value
		if(root.val == p.val || root.val == q.val)
			return root;
		// recurse over left tree and check if the values match
		TreeNode left = lcaBinaryTree(root.left, p, q);
		// recurse over right tree and check if the values match
		TreeNode right = lcaBinaryTree(root.right, p, q);
		// if the values in left tree is null, return right tree, if values in right is null, return left tree so we can recurse over left tree
		// if both the left and right tree are null(leaf nodes may be) we return the root and recurse over the root.
		return (left==null)?right: (right==null)?left:root;
	}
	
public static void main(String[] args) {
		
		lcaBT sdm = new lcaBT();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		TreeNode p = new TreeNode(3);
		TreeNode q = new TreeNode(1);
		TreeNode res = sdm.lcaBinaryTree(root, p,q);
		System.out.println(res.val);
	}
}
