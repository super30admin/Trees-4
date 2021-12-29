//time - o(h+k)
//space - o(h)

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
        int val = 0;
        int counter = 0;
        Stack<TreeNode> stack = new Stack<>();
        
        while(!stack.isEmpty() || root!=null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            counter += 1;
            if(counter == k) {
                val = root.val;
                break;
            }
            root = root.right;
        }
                
        return val;
    }
}
