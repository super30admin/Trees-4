// TC: O(n)
// SC: o(n)
// works on leetcode

public class LowestCommonAncestorBST {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (true) {
      if (root.val > p.val && root.val > q.val) {
        root = root.left;
      } else if (root.val < p.val && root.val < q.val) {
        root = root.right;
      } else {
        return root;
      }
    }
  }
}
