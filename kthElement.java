// TC : O(n)
// SC : O(h)
// Ran on LC : Yes
// Problems faced : None.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	int count;
	int res;
	boolean flag;
	public int kthSmallest(TreeNode root, int k) {
		 count = k;
		 flag = false;
		 helper(root, k);
		 return res;
	}
	
	private void helper(TreeNode root, int k) {
		 if(root == null) return;
		 
		 if(!flag)
			  helper(root.left, k);
	
		 count--;
		 if(count == 0) {
			  res = root.val;
			  flag = true;
		 }
		 
		 if(!flag)
			  helper(root.right, k);
			  
	}
}