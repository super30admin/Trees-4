// Time Complexity : O(h) - h - height of tree. On worst case if p & q are at the leaf of same parent 
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Appraoch
// If the given P and Q are LESSER than root then both have common parent in LEFT sub tree
// If P & Q are GREATER than root then both have common parent(ancestor) in RIGHT sub tree
// In either of P or Q , one of them is greater than root and other is lesser than the root then the root is the least common ansestor.

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
                
        
        
        //Iterative 
        while(root!= null){
            if(root.val > p.val && root.val> q.val)
                root = root.left;
            else if(root.val< p.val && root.val< q.val)
                root = root.right;
            else
                return root;
        }
        
        return null;
        //Recursion
        // return lca(root, p, q);
       
    }
    
    //Recursion
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        // logic
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
