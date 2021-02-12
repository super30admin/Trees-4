/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * 
 */
// Iterative Approach
// TC: O(N)
// SC: O(H)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while ( !stack.isEmpty() || root != null)
        {
            while ( root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if ( --k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }
}

// Recursive Approach
// TC: O(N)
// SC: O(H)
// Did it run successfully on Leetcode? : Yes
class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;
        inorder(root, k);
        return result;
    }
    private void inorder(TreeNode root, int k)
    {
        //base
        if (root == null)
          return;
        //logic
        inorder(root.left, k);
        count++;
        if ( count == k)    
        { 
            result = root.val;
        }
        if ( result == -1)     //optimization, dont iterate full tree, just return as soon as result is populated
           inorder(root.right, k);
    }
}
