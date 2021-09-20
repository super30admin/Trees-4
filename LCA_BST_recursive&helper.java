//235. Lowest Common Ancestor of a Binary Search Tree: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Time Complexity : O(Height)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

//using helper method

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
    
    TreeNode result;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        
        helper(root, p, q);
        return result;   
    }
    
    private void helper(TreeNode root, TreeNode p, TreeNode q){
        //base
        if(root == null) return;
        //logic
        if(p.val < root.val && q.val < root.val){ //when p & q < root
            helper(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val){ // when p & q > root
            helper(root.right, p, q);
        } else { // when p < root < q
            result = root;
            return;
        }
    }
}