// Time Complexity : O(N) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Check if root val is in between p and q. If so return root. Else if
 * root is less than both p and q, that means ancestor lies in left subtree
 * so move the root to root.left, else if root is greater than p and q, then
 * move the root to root.right. Else if it is in between p and q, that would
 * be the result. return that current node as result.
 *
 */
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		int pVal = p.val;
		int qVal = q.val;
		TreeNode curr = root;
		while (curr != null) {
			int parent = curr.val;
			if (pVal < parent && qVal < parent)
				curr = curr.left;
			else if (pVal > parent && qVal > parent)
				curr = curr.right;
			else
				return curr;
		}
		return curr;
	}
}
