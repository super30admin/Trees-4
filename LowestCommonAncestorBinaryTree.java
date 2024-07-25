// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Recursive solution
class Solution {
  List<TreeNode> pathP;
  List<TreeNode> pathQ;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) return null;
    pathP = new ArrayList<>();
    pathQ = new ArrayList<>();
    dfs(root, p, q, new ArrayList<>());
    for(int i = 0; i<pathP.size(); i++) {
      if(pathP.get(i) != pathQ.get(i)) {
        return pathP.get(i-1);
      }
    }
    return null;
  }

  void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
    // Base
    if(root == null || (pathP.size() > 0 && pathQ.size() > 0)) return;
    // Logic
    // Action
    path.add(root);
    if(root == p) {
      pathP = new ArrayList<>(path);
      pathP.add(root);
    }
    if(root == q) {
      pathQ = new ArrayList<>(path);
      pathQ.add(root);
    }
    // Recurse
    dfs(root.left, p, q, path);
    dfs(root.right, p, q, path);
    // Backtrack
    path.remove(path.size()-1);
  }
}

