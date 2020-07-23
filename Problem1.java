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

//Time Complexity: O(n) n - number of nodes in the tree
//Space Complexity: O(n)
class Solution {
    int count;
    TreeNode result;
    /*
    public int kthSmallest(TreeNode root, int k) {
        //Iterative approach
        
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            
            root = root.right;
        }
        
        return -1;
    }
    */
    public int kthSmallest(TreeNode root, int k) {
        //Recursive approach
        result = null;
        count = k;
        inorder(root);
        return result.val;
    }
    
    private void inorder(TreeNode node) {
        if(node == null)
            return;
        inorder(node.left);
        count--;
        if (count == 0 ) {
            result = node;
            return;
        }
        inorder(node.right);
    }
}

