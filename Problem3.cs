// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
If root equals p/q/null I return root. I recursively call the method on both the left and right child of the current node. 
If I return null from the function call on the left child, I return the result from right and vice versa. If I return some
value from both function calls on left and right child, I return the root value.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null)
        {
            return root;
        }

        TreeNode left = LowestCommonAncestor(root.left, p, q);
        TreeNode right = LowestCommonAncestor(root.right, p, q);

        if(left==null)
        {
            return right;
        }

        else if(right == null)
        {
            return left;
        }

        return root;
    }
}