// Time Complexity : O(h)
// Space Complexity : 1 - O(1), 2 - O(h)
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

// Iterative solution
/*class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        while(true) {
            if(root.val > p.val && root.val > q.val) root = root.left;
            else if(root.val < p.val && root.val < q.val) root = root.right;
            else return root;
        }
    }
}*/

// Iterative solution
class Solution {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) return null;
    return dfs(root, p, q);
  }

  TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) return null;
    if(root.val > p.val && root.val > q.val) return dfs(root.left, p, q);
    else if(root.val < p.val && root.val < q.val) return dfs(root.right, p, q);
    else return root;
  }
}