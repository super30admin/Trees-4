import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Time complexity : O(n)
 * Space Complexity : O(H) --> height of the tree
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null){
            return 0;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root != null || !stack.isEmpty()){
            
            while(root != null){
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
        
        return 0;
        
    }
}