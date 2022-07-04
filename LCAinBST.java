//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Time Complexity :O(n)  
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
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
        while(root!=null)
        {
            if(root.val<p.val && root.val<q.val) //if both the values are greater they ligh right
                root=root.right;
            else if(root.val>p.val && root.val>q.val)
                root=root.left;
            else  //one node is at left and one node is at right
                return root; //so the root is the lca
        }
       return root;
    }
    //this recursive solution has stack space
    public TreeNode recur(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root.val<p.val && root.val<q.val) return recur(root.right,p,q);
        if(root.val>p.val && root.val>q.val) return recur(root.left,p,q);
        return root;
    }
}