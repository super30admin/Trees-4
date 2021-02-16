//Time Complexity: O(H+k) where H is tree height.
//Space Complexity: O(H) to keep the stack. O(N) worst case, O(logN) average case. 

class Solution {
  public int kthSmallest(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

    while (true) {
      while (root != null) { 
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();
      if (--k == 0) return root.val;
      root = root.right;
    }
  }
}