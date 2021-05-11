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

//Approach - use Stack to store the elements
// Iterate through the leftmost element and put in stack,
// pop each element and decement k
// k == 0 , then we have found answer, if not start searching the right side of tree

//Time Complexity - O(H+k) - H - height of tree, k given kth element
//Space Complexity - O(H) -
//                worst case if the tree is skewed to left side then O(n)
//                where n - number of nodes in the tree
class Solution {
  public int kthSmallest(TreeNode root, int k) {

    if(root == null){
      return -1;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while(!stack.isEmpty() || root != null){

      while(root != null ){
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      k--;

      if(k == 0){
        return root.val;
      }

      root = root.right;
    }

    return -1;
  }
}



//Approach - Recursion
//Time Complexity - O(H+k) - H - height of tree, k given kth element
//Space Complexity - implicit O(H) - for the recursion stack
class Solution {
  int result = 0;
  int count = 0;
  public int kthSmallest(TreeNode root, int k) {

    inorder(root, k);
    return result;
  }

  public void inorder(TreeNode node, int k){
    if(node == null){
      return;
    }

    inorder(node.left, k);

    if(++count == k){
      result = node.val;
      return;
    }

    inorder(node.right, k);
  }
}
