// Time complexity: O(n+m) where n = number of vertices and m = number of edges
// Space complexity: O(maxDepth)

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
        
        int counter = 0;
        
        while(root != null || !stack.isEmpty()){
            
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            TreeNode top = stack.pop();
            counter += 1;
            if(counter == k){
                return top.val;
            }
            
            root = top.right;
        }
        
        return -1;
    }
}
