// Time Complexity : O(N)- As we need to traverse every node
// Space Complexity : O(N) - Internal stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
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
       int pval = p.val;
       int qval = q.val;
        
       TreeNode node = root;
        
       finalval(node,p,q);
       return result; 
    }
    public boolean finalval(TreeNode node,TreeNode p,TreeNode q){
        if(node == null) return false;
        
        int left = (finalval(node.left,p,q)? 1 : 0);
        
        int right = (finalval(node.right,p,q)? 1 : 0);
        
        int root = (node.val == p.val || node.val == q.val)? 1 : 0;
        
        if(left + right + root >= 2){
            this.result = node;
        }
        return (left + right + root > 0);
    }
}

// Your code here along with comments explaining your approach
