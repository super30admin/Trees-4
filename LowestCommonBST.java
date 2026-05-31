// Time Complexity : O(h) where h is the height of the tree
// Space Complexity : O(1) iterative approach, O(h) recursive approach where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
// 1. We will start from the root and compare the values of p and q with the current node's value.
// 2. If both p and q are smaller than the current node's value, then we will move to the left subtree.
// 3. If both p and q are greater than the current node's value, then we will move to the right subtree.
// 4. If one of p or q is smaller than the current node's value and the other is greater than the current node's value, then we have found the lowest common ancestor and we will return the current node.
// 5. We will continue this process until we find the lowest common ancestor or we reach the end of the tree.   
 //Definition for a binary tree node.
  public class LowestCommonBST {
      int val;
     TreeNode left;
     TreeNode right;
 
      LowestCommonBST(int x) {
          val = x;
      }
  }
 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode curr = root;

        while (true) {

            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            }
            else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            }
            else {
                return curr;
            }
        }
    }
}