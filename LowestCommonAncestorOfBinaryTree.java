/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Approach - Recursion - check on left side once thats done check on right side
//check if a node has both left and right node return values, then thats the LCA

//Time Complexity - O(N) - worst case - N is the number of nodes in Tree
//Space Complexity - O(N) - worst case for recursion call stack
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if(root == null || root == p || root == q){
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if(left != null && right != null) {
      return root;
    }
    else if(right == null){
      return left;
    }
    else if(left == null){
      return right;
    }

    return null;

  }
}
