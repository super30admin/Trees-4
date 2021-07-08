// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Return the Kth inorder traversal node's value. Do the inorder traversal, as the K value
reaches 0 as it decrements with each recursive call, return the root value.
*/

// RECURSIVE
class Solution {
    int K;
    int res=0;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        Ksmallest(root);                                                // Start the recursion
        return res;
    }
    private void Ksmallest(TreeNode root){
        if(root == null){return;}
        Ksmallest(root.left);                                                       // Inorder traversal
        K--;
        if(K == 0){res = root.val;}                                         // K has reached 0, return the node value
        Ksmallest(root.right);                                              // Traverse right subtree
    }
}

// ITERATIVE
class Solution {
    public int kthSmallest(TreeNode root, int k) {
      if(root == null){return 0;}
      Stack<TreeNode> stk = new Stack<>();
      stk.add(root);
      while(!stk.isEmpty()){
          while(root != null){                                                      // Inorder traversal starts
              root = root.left;
              if(root != null) stk.push(root);                                              // Traversing left subtree
          }
          root = stk.pop();                                             // Prepared for traversing right subtree
          k--;
          if(k == 0){return root.val;}                                  // K value has decremented to 0, return the node value
          root = root.right;
          if(root != null) stk.push(root);                                      // Traverse the right subtree
          }
        return -1;
    }
}