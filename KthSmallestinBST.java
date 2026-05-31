// Time Complexity :O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
// 1. We will do an inorder traversal of the tree and keep a count of the nodes visited.
// 2. When the count is equal to k, we will store the result and return
// 3. We will use a helper function to do the inorder traversal and update the count and result accordingly.
// 4. We will also check if the result is already found before doing the recursive calls to avoid unnecessary traversal.
// Definition for a binary tree node.
  public class KthSmallestinBST {
      int val;
      KthSmallestinBST left;
      KthSmallestinBST right;
 
      KthSmallestinBST() {}
 
      KthSmallestinBST(int val) {
          this.val = val;
      }
 
      KthSmallestinBST(int val, KthSmallestinBST left, KthSmallestinBST right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
 

class Solution {

    int count;
    KthSmallestinBST result;

    public int kthSmallest(KthSmallestinBST root, int k) {

        count = 0;
        helper(root, k);

        return result.val;
    }

    private void helper(KthSmallestinBST root, int k) {

        if (root == null) {
            return;
        }
       
        if(result==null)
        {
        helper(root.left, k);
        }

        count++;

        if (count == k) {
            result = root;
        }
         if(result==null)
        {
        helper(root.right, k);
        }
    }
}