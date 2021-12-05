// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class LCA_BST {
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(p.val<root.val && q.val<root.val){
	            return lowestCommonAncestor(root.left,p,q);
	        }else  if(p.val>root.val && q.val>root.val){
	            return lowestCommonAncestor(root.right,p,q);
	        }else{
	            return root;
	        }

	 }
	 
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
 	      }
 }
}


