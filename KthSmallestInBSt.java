
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
/*
method1 - iterative method to find kth node
Use stack to do inorder traversal and keep track of count. 
when count == k, return the node value.

method 2: recurisve

time complexity : O(log n)
space complexity : O(logn)

*/
class Solution {
    
    int count = 0;int result = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null)return -1;
        
        //method 1 : ietrative
        // Stack<TreeNode> stack = new Stack<>();
        // while(!stack.isEmpty() || root != null){
        //     while(root != null){
        //         stack.push(root);
        //         root = root.left;
        //     }
        //     root = stack.pop();
        //     k--;
        //     if(k == 0)return root.val;
        //     root = root.right;
        // }
        // return -1;
         helper(root,k);
        return result;
    }
    private void helper(TreeNode root, int k){
        if(root == null)return;
        
         helper(root.left, k);
        count += 1;
        if(count == k){
            result = root.val;return;
        }
        helper(root.right, k);
    }
}