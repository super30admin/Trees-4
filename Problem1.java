// Time Complexity : O(h)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//235. Lowest Common Ancestor of a Binary Search Tree
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

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
    //Iteration
    //time: O(h)
    //space: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while(true){
            
            if(p.val<root.val && q.val<root.val){
                root = root.left;
            }
            
            if(p.val>root.val && q.val>root.val){
                root = root.right;
            }
            
            if(p.val == root.val || q.val == root.val){
                return root;
            }
            
            if((p.val>root.val&&q.val<root.val) || (p.val<root.val&&q.val>root.val)){
                return root;
            }
        }
        
    }
}



/*
class Solution {
    //Recursion
    //time: O(h)
    //space: O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if(root == null || root == p || root ==q) return root;
        
        //logic
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        
        if(p.val == root.val || q.val == root.val){
            return root;
        }
        
        return root;
    }
}
*/