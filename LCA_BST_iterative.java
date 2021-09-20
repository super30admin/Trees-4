//235. Lowest Common Ancestor of a Binary Search Tree: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Time Complexity : O(Height)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
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
        if(root == null) return root;
        
        //iterative approach
        while(true){
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            } else if(p.val > root.val && q.val > root.val){
                root = root.right;
            } else {
                return root;
            }
        }
        
    }
}

//why this program doesn't throws a error when there is no default return value??
//answer: bcz the result is returned directly from the while loop. Hence, it is not throwing any error.