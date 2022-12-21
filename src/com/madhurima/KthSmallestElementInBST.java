// Time Complexity : O(n) worst case will visit all nodes
// Space Complexity : O(height of tree) (in case of recursion, its the recursion stack and in case of stack, its height of stack)
// Did this code successfully run on Leetcode : yes

package com.madhurima;

import java.util.Stack;

public class KthSmallestElementInBST {

}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class SolutionRecursion {

    int count;
    int result;

    //recursive in-order travelsal
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;

        result = -1;
        dfs(root, k);
        return result;

    }

    private void dfs(TreeNode root, int k){
        //base
        if(root ==  null){
            return;
        }

        //logic
        if(result == -1){ // if you already have the result, don't continue with the recursion
            dfs(root.left, k);
        }


        count++;
        if(count == k){
            result = root.val;
            return;
        }

        if(result == -1){
            dfs(root.right, k);
        }
    }
}

class SolutionIterative {

    //iterative approach
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }

        Stack<TreeNode> s = new Stack<>();
        int count = 0;

        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }

            root = s.pop();
            count++;

            if(count == k){
                return root.val;
            }

            root = root.right;

        }

        return count;
    }
}
