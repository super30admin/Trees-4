// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class LCA_BT {
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root==null){
	            return null;
	        }
	        
	        if(p.val==root.val || q.val==root.val){
	            return root;
	        }
	        
	        TreeNode left=lowestCommonAncestor(root.left,p,q);
	        TreeNode right=lowestCommonAncestor(root.right,p,q);
	        
	        if(left!=null && right!=null){
	            return root;
	        }else if(left!=null){
	            return left;
	        }else if(right!=null){
	            return right;
	        }
	        
	        return null;
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
