// Time Complexity : O(H), h - height of tree
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
/*class Solution {
    int count;
    int answer;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        count = k;
        answer = -1;
        dfs(root);
        return answer;
    }

    void dfs(TreeNode root) {
        // Base
        if(root == null) return;
        // Logic
        dfs(root.left);
        count--;
        if(count == 0) {
            answer = root.val;
            return;
        }
        dfs(root.right);
    }
}*/

// Using a stack
class Solution {
  public int kthSmallest(TreeNode root, int k) {
    if(root == null) return -1;
    Stack<TreeNode> stack = new Stack<>();
    while(root != null || !stack.isEmpty()) {
      while(root!=null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      k--;
      if(k == 0) {
        return root.val;
      }
      root = root.right;
    }
    return -1;
  }
}
