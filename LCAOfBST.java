//Iterative
// Time Complexity : O(h) h is height of tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;

        while(true){
            if(root.val<p.val && root.val<q.val){
                root = root.right;
            } else if(root.val>p.val && root.val>q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
    }
}


//Recursive
// Time Complexity : O(h)
// Space Complexity : O(h) h is height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;

        if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right, p, q);
        } else if(root.val>p.val && root.val>q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}