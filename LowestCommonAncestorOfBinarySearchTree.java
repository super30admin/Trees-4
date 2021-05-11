/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Approach - if the values of both q and p are less than root's val, keep on checking left side
//if the values of both q and p are less than root's val, keep on checking right side
//if p and q are on either side of the node, return the node as its result

//Time Complexity - O(N) - worst case - N is the number of nodes in Tree
//Space Complexity - O(N) - worst case for recursion call stack

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if(root == null || root == p || root == q){
      return root;
    }

    if(p.val < root.val && q.val < root.val){
      return lowestCommonAncestor(root.left, p, q);
    }

    if(p.val > root.val && q.val > root.val){
      return lowestCommonAncestor(root.right, p, q);
    }

    return root;
  }
}
