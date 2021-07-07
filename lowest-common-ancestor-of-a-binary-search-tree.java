// Time Complexity : O(logN)
// Space Complexity : O(logN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Recursion
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null)
//             return null;
        
//         if (p.val < root.val && q.val < root.val)
//             return lowestCommonAncestor(root.left, p, q);
//         else if (p.val > root.val && q.val > root.val)
//             return lowestCommonAncestor(root.right, p, q);
//         else
//             return root;
//     }
// }

// Iteration
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        
        while(root != null)
        {
            if(p.val < root.val && q.val < root.val)
                root=root.left;
            else if(p.val > root.val && q.val > root.val)
                root=root.right;
            else
                return root;
        }
        return null;
    }
}
