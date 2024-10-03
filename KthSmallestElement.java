/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//inorder traversal -> optimise -> maintain a counter
// not sure on int based recurssion -> will need practice
// using stack -> go over, not sure

// what if k is given again and again can we cache our result in a hashmap?
// for k is 1, for k is 5 and so on..
// we

//for the stack solution
//TC: O(h + k) k-> kth smallest element
//SC : O(h)

//for the counter solution
//TC:O(n)
//SC: O(n)

//works on leetcode
class Solution {

  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> st = new Stack<>();

    while (root != null || !st.isEmpty()) {
      while (root != null) {
        st.push(root);
        root = root.left;
      }
      root = st.pop();
      k--;
      if (k == 0) return root.val;
      root = root.right;
    }
    return 0;
  }
}
