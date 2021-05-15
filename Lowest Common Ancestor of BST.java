// Time Complexity :O(h)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)
      return null;
    while (root != null) {
      if (p.val < root.val && q.val < root.val)
        root = root.left;

      else if (p.val > root.val && q.val > root.val)
        root = root.right;

      else
        return root;
    }
    return null;
  }
}