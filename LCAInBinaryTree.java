import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Time Complexity : O(N) 
//Space Complexity : O(N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Put the parents of each node of binary tree in a map. Then, from p, add it
 * and its ancestors to a list. Now, from q, check if its in the ancestors list.
 * If so return q, else update q to its ancestor/parent. repeat this untill q is
 * null or common ancestor is found.
 *
 */
class Solution {
	Map<TreeNode, TreeNode> map = new HashMap<>();

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		dfs(root, null);
		List<TreeNode> ancestors = new ArrayList<>();
		TreeNode pCurr = p;
		while (pCurr != null) {
			ancestors.add(pCurr);
			pCurr = map.get(pCurr);
		}

		TreeNode qCurr = q;
		while (qCurr != null) {
			if (ancestors.contains(qCurr))
				return qCurr;
			qCurr = map.get(qCurr);
		}
		return null;
	}

	public void dfs(TreeNode root, TreeNode parent) {
		if (root != null) {
			map.put(root, parent);
			dfs(root.left, root);
			dfs(root.right, root);
		}
	}
}