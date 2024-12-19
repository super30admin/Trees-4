public class problem1 {
    // Time Complexity : O(n)
// Space Complexity : O(H)
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
  int count;
  int result;

  public int kthSmallest(TreeNode root, int k) {
      this.count = 0;
      helper(root, k);
      return result;
  }
  private void helper(TreeNode root, int k) {
      //base case
      if (root == null) return;


          helper(root.left, k);

      count++;
      if (count == k)
      {
          this.result = root.val;
          return;

      }

          helper(root.right, k);

  }
}
