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
// Approach : Iterative Approach . 
// Brute Force - create inoreder traversal of BST and go thorough the nodes and return kth index element
// Time : O(K) -> O(N ) # worst case
// Space : O(1)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        while(!stk.isEmpty() || root!=null){
            while(root!=null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            k--;
            if(k == 0) return root.val;
            root = root.right;
        } 
        return -1;
    }
}

// Approach : Recursion . 
// Time : O(K) -> O(N ) # worst case k reaches to N
// Space : O(h) # height of the Tree
class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        helper(root);
        return result;
    }

    private void helper(TreeNode root){
        // base case
        if (root == null) return;

        // logic
        helper(root.left);
        // stkk.pop() // root
        // process
        count--;
        if(count == 0){
            result = root.val;
            return;
        }
        // recursion on right
        helper(root.right);
    }
}
