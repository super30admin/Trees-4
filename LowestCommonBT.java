// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode :     Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
// 1. We will start from the root and check if the current node is equal to p or q. If it is, then we will return the current node.
// 2. We will then recursively call the function for the left and right subtrees.
// 3. If both the left and right recursive calls return null, then we will return null.
// 4. If one of the recursive calls returns null, then we will return the other recursive call's result.
// 5. If both the recursive calls return a non-null value, then we have found the lowest common ancestor and we will return the current node.
// Definition for a binary tree node.
  public class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
 
      TreeNode(int x) {
          val = x;
      }
  }
 //Definition for a binary tree node.

 //Definition for a binary tree node.
  public class LowestCommonBT {
      int val;
     TreeNode left;
     TreeNode right;
 
      LowestCommonBT(int x) {
          val = x;
      }
  }

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        } 
        else if (left == null) {
            return right;
        } 
        else if (right == null) {
            return left;
        } 
        else {
            return root;
        }
    }
}