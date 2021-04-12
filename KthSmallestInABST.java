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

// TC - O(n), SC - O(n)
// LC - 230

// We are doing an inorder traversal, when we are left most, we pop an element to go to right part of tree, at that place we decrement k and if k equals 0 we return that popped value
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            k--;
            if(k == 0){
                return top.val;
            }
            root = top.right;
        }
        return -1;
    }
}

// Recursive Solution

// class Solution {
//     List<Integer> list = new ArrayList<>();
//     public int kthSmallest(TreeNode root, int k) {
//         inorderTraversal(root);
//         return list.get(k-1);
//     }
    
//     private void inorderTraversal(TreeNode root){
//         if(root == null){
//             return;
//         }
        
//         inorderTraversal(root.left);
//         list.add(root.val);
//         inorderTraversal(root.right);
//     }
// }