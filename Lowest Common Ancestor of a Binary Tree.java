// Time Complexity : O(n)
// Space Complexity : O(logn) (stack space)
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
    //declare result
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //initialize to null
        result = null;
        //call helper method to find LCA of p and q
        helperLCAinBT(root, p, q);
        //return the result (LCA of p and q)
        return result;
        
    }
    
    private boolean helperLCAinBT(TreeNode root, TreeNode p, TreeNode q) {
        //Base Case
        //if null node encountered return false
        if(root == null){
            return false;
        }
         
        //Logic 
        
        //for curr node ; check if node = p/q
        //if found make rootnode = 1
        int rootnode = (root.val == p.val || root.val == q.val) ? 1 : 0;
        
        //call recursively on left subtree (till node = null) 
        //(and check of leaf found on left subtree) 
        //if found (the statement is true) checks in this case  
        //condition : if(rootnode + leftSubTree + rightSubTree == 1) return true, so value becomes 1
        int leftSubTree = helperLCAinBT(root.left, p, q)? 1 : 0; 
        
        //similarly for right sub tree
        int rightSubTree = helperLCAinBT(root.right, p, q)? 1 : 0; 
        
        //if till the node : value == 2, then both p and q found and the curr node is the LCA 
        //so set result = root
        if(rootnode + leftSubTree + rightSubTree == 2) {
            result = root; 
        }
        
        //if found, return true (so value of leftSubTree / rightSubTree, becomes = 1) 
        if(rootnode + leftSubTree + rightSubTree == 1) {
            return true;
        }
        
        //else p/q found, return false
        else {
            return false;
        }
        
    }
}

