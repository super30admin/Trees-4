/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nope


// Your code here along with comments explaining your approach
/*Approach:
1) in this we are given a BST and thus can easily find the root
2) we just check if root.val > P and root.val>q, then we move left, property of BST
3) similarly we check vice versa and move right
4) if both dont meet that means, root.val ==p or root.val==q and we need to return root in this case
*/


class lowestCommonAncestorInBST {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     if(root==null)
     {
         return root;
     }
     
        if(root.val>p.val && root.val>q.val)
        {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val< p.val && root.val< q.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }
        else
            return root;
        
        
        
    }
}