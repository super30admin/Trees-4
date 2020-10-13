// TC: O(N) traversing all the nodes in tree in worst case
// SC:(logN) since we are recursing and storing only height of tree

public class LCABST {

	public TreeNode bstLca(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root == null)
			return null;
		// if the root val is greater then maximum of both values, we know tht to find LCA,
		//we need to move left because we know lesser values in BST are on left side of tree
		if(root.val > Math.max(p.val, q.val)) {
			return bstLca(root.left, p,q);
		}
		// if the root val is greater than minimum of both p and q values, we know we need to mvoe right
		// since higher values are present on right side of BST
		if(root.val < Math.min(p.val, q.val))
			return bstLca(root.right, p, q);
		return root;
	}
}
