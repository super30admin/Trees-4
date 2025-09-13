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
 // This solution uses a stack based approach to iterate through the BST in and in order fashion. While we traverse, we keep decrementing the k so that when it reaches 1 it means we have iterated the tree for k elements until then and return the specific one.
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr!=null) {
            while(curr!=null) {
                stack.add(curr);
                curr=curr.left;
            }
            curr = stack.pop();
            if(k==1) return curr.val;
            k--;
            curr=curr.right;
        }
        return -1;
    }
}
