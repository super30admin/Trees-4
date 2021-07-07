package s30Coding;

//Time Complexity :- O(log(n))
//Space Complexity :- O(h)
//LeetCode :- Yes

public class LowestCommonAncestorInBinarySearchTree {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right,p,q);
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        else return root;
    }
}
