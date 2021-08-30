//Time complexity: O(H + k), where H is the maximum height of the tree.
//Space complexity: O(H)

class TreeNode {
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
 
  class Solution1 {
      int element = 0;
      int count = 0;

      public void helper(TreeNode root, int k) {
          if (root == null)
              return;
          helper(root.left, k);
          if (++count == k) {
              element = root.val;
              return;
          }
          helper(root.right, k);
      }

      public int kthSmallest(TreeNode root, int k) {
          helper(root, k);
          return element;
      }
  }