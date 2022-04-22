import java.util.Stack;

/**
 * Time complexity is n
 * space complexity is h - height of the tree
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack()<>();
        
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            k--;
            if(k == 0) {
                return node.val;
            }
            root = node.right;
        }
        return -1;
        
    }
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}