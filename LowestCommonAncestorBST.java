// Time Complexity : The time complexity is O(h) where h is the height of the tree
// Space Complexity : The space complexity is O(h) where h is the height of the tree
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

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return dfs(root,p,q);

    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){

        // Base case
        if(p.val < root.val && q.val > root.val){return root;}
        if(q.val < root.val && p.val >  root.val){return root;}
        if(p.val == root.val || q.val == root.val){return root;}

        // Since its a BST, traverse according to the conditions
        if(p.val < root.val && q.val < root.val){
            return dfs(root.left,p,q);
        }
        else{
            return dfs(root.right,p,q);
        }

    }
}