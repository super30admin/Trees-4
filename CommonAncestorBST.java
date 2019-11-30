public class CommonAncestorBST {

	//	Time:  O(n) 
	//	Space O(1) 
	//	LeetCode: yes

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


	public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
		int parent = root.val;
		int node1 = p.val;
		int node2 = q.val;
		//Comparing if p q are on right side of BST
		if(node1 > parent && node2 > parent){
			return lowestCommonAncestorBST(root.right, p,q);
			//Comparing if p q are on left side of BST
		}else if(node1 < parent && node2 < parent){
			return lowestCommonAncestorBST(root.left, p,q);
			//else, if p & q are on either side, return root
		}else{
			return root;
		}
	}
}