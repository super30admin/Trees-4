// 230.
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
    
    int[] result = new int[1];
    
    public int kthSmallest(TreeNode root, int k) {
        //return kthSmallestIterative(root, k);
        kthSmallestRecursive(root, new int[]{k});
        return result[0];
    }
    
    //perform inorder traversal iteratively
    //while popping from stack, increment the counter
    //if counter = k, return popped element
    //time - O(n) - visist every node in worst case to find largest element
    //space - O(max depth of tree) - stack has largest size when traversing the longest root to leaf path
    private int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> support = new Stack<>();
        int counter = 0;
        while(root != null || !support.isEmpty())
        {
            while(root != null)
            {
                support.push(root);
                root = root.left;
            }
            TreeNode top = support.pop();
            counter++;
            if(counter == k)
            {
                return top.val;
            }
            root = top.right;
        }
        return 0;
    }
    
    //time - O(n) - visist every node in worst case to find largest element
    //space - O(max depth of tree) - call stack has largest size when traversing the longest root to leaf path
    private void kthSmallestRecursive(TreeNode root, int[] k) {
        //base
        if(root == null)
        {
            return;
        }
        //logic
        kthSmallestRecursive(root.left, k);
        k[0]--; //decrement k when processing each node after visiting its full left sub tree
        if(k[0] == 0) // if k becomes 0, populate result and return
        {
            result[0] = root.val;
            return;
        }
        kthSmallestRecursive(root.right, k);
    }
}
