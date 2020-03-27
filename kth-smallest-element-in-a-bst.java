// Time Complexity : O(N)
// Space Complexity : O(N)
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
// Recursion with Global variables
// class Solution {
//     int K;
//     int result;
//     public int kthSmallest(TreeNode root, int k) {
//         K=k;
        
//         inorder(root);
        
//         return result;
//     }
//     private void inorder(TreeNode root)
//     {
//         if (root == null)
//             return;
        
//         inorder(root.left);
//         K--;
//         if(K == 0)
//         {
//             result = root.val;
//             return;
//         }
//         inorder(root.right);
//     }
// }

// Iterative approach
// class Solution{
//     public int kthSmallest(TreeNode root, int k) {
//         if (root == null)
//             return 0;
        
//         Stack<TreeNode> stack = new Stack<>();
        
//         while(root != null || !stack.isEmpty()){
//             while(root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
            
//             root = stack.pop();
//             k--;
//             if(k == 0) return root.val;
            
//             root = root.right;
//         }
        
//         return 0;
//     }
// }

// No Global variables 
class Solution{
    public int kthSmallest(TreeNode root, int k) {
        Wrapper wrapper = new Wrapper(k);
        
        inOrder(root, wrapper);
        
        return wrapper.result;
    }
    private void inOrder(TreeNode root, Wrapper wrapper){
        if(root == null) 
            return;
        
        inOrder(root.left, wrapper);
        
        wrapper.K--;
        if(wrapper.K == 0) {
            wrapper.result = root.val;
            return ;
        }
        
        inOrder(root.right, wrapper);
    }
}
class Wrapper{
    int K;
    int result;
    Wrapper(int k) {
        this.K=k;
    }
}
