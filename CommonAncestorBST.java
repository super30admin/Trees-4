public class CommonAncestorBST {

	//	Time:  O() 
	//	Space O(1) 
	//	LeetCode: yes
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		int parent = root.val;
		int node1 = p.val;
		int node2 = q.val;
		if(node1 > parent && node2 > parent){
			return lowestCommonAncestor(root.right, p,q);
		}else if(node1 < parent && node2 < parent){
			return lowestCommonAncestor(root.left, p,q);
		}else{
			return root;
		}
	}
}