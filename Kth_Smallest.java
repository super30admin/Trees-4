// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Kth_Smallest {
	 int result;
	    int x;
	    public int kthSmallest(TreeNode root, int k) {
	        x=k;
	        result=-1;
	        helper(root,k);
	        return result;
	    }
	    
	    public void helper(TreeNode root, int k){
	        if(root==null){
	            return;
	        }
	        
	        helper(root.left,x);
	        x--;
	        if(x==0){
	            if(result==-1){
	            result=root.val;
	            }
	            return;
	        }
	        
	        helper(root.right,x);
	        return;
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
