/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// is Worked on leetcode :  YES
// time complexity : O(N)
// space complexity : O(max ddepth of tree)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if root is null return null
        if (root  == null)  return null;
        
        // if we find any of the element return that 
        // here we allowed node to be descedent of it self
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        
        // get left Tree LCA
        
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        // get right Tree LCA
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // if left LCA and right LCA both are not null that
        // means p and q are different side so that root is LCA
        
        if(leftLCA != null && rightLCA != null) {
            return root;
        } 
        // if anyof the side return null LCA , then return not null lca of other side
        else if(leftLCA!= null && rightLCA == null) {
            return leftLCA;
        } else{
            return rightLCA;
        }
        
        
    }
}

// p = 5 q = 1  ans = 3

// p  =  2 q = 4 ans  = 2
// p = 6 q = 4 ans 5
// p = 8 q = 5 ans = 3
