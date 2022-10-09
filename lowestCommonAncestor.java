// TC : O(h)
// SC : O(h)
// LC : Yes
// Problems faced : None.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	List<TreeNode> resp;
	List<TreeNode> resq;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 if(root == null) return null;
		 dfs(root, p, q, new ArrayList<>());
		 
		 for(int i = 0; i < resp.size(); i++) {
			  if(resp.get(i) != resq.get(i)) {
					return resp.get(i-1);
			  }
		 }
		 return null;
	}
	
	private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
		 if(root == null) return;
		 
		 path.add(root);
		 
		 if(root == p) {
			  resp = new ArrayList<>(path);
			  resp.add(root);
		 }
		 
		 if(root == q) {
			  resq = new ArrayList<>(path);
			  resq.add(root);
		 }
		 
		 dfs(root.left, p, q, path);
		 dfs(root.right, p, q, path);
		 
		 path.remove(path.size()-1);
	}
}