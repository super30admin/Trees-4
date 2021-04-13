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
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack<>();
        
        //do the inorder traversal
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            //when you pop the element decrement the k value
            TreeNode top = stack.pop();
            k--;
            if(k == 0){//when k == 0 i.e., element at the top is kth smallest element
                return top.val;
            }
            
            root = top.right;
        }
            
        return -1;
    }
}
// Time Complexity: O(h)
//Space Complexity: O(h)