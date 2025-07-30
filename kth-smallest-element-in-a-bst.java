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

//recursive inorder
//void based
//Time = O(n)
//Space = O(n)
class Solution {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        this.result = Integer.MAX_VALUE;
        count = k;
        helper(root);
        return result;
    }
    private void helper(TreeNode root){
        if(root == null) return;
        if(result != Integer.MAX_VALUE) return;//if(result != null) return;
        helper(root.left);
        count--;
        if(count == 0){
            result = root.val;
        }
        helper(root.right);
    }
}

// //recursive inorder
// //int based recursion
// class Solution {
//     int count;
//     public int kthSmallest(TreeNode root, int k) {
//         count = k;
//         return helper(root);
//     }
//     private int helper(TreeNode root){
//         if(root == null) return Integer.MAX_VALUE;
//         int left = helper(root.left);
//         count--;
//         if(count == 0){
//             return root.val;
//         }
//         int right = helper(root.right);
//         // if(left != Integer.MAX_VALUE) return left;
//         // if(right != Integer.MAX_VALUE) return right;
//         // return Integer.MAX_VALUE;
//         return Math.min(left,right);
//     }
// }

//Iterative inorder solution