// Time Complexity :O(h + k)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
  public int kthSmallest(TreeNode root, int k) {
    if (root == null)
      return -1;

    Stack<TreeNode> s = new Stack<>();

    while (root != null || !s.isEmpty()) {
      while (root != null) {
        s.push(root);
        root = root.left;
      }
      root = s.pop();
      k--;
      if (k == 0)
        return root.val;
      root = root.right;
    }

    return -1;
  }
}