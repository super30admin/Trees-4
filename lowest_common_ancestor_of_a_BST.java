// Time Complexity : O(log(n)), where n is the number of nodes in the tree
// Space Complexity :O(log(n)), where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Correct me on the space and time complexity

//Three Liner Explanation of your code in plain English
//1. Check if p and q are smaller than root, then move to explore the left subtree
//2. Check if p and q are greater than root, then move to explore the right subtree
//3. If above condition doesnot meet then, root is the LCA


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
        //base
        if(root == null) return null;
        //logic
        //if p and q are smaller than root, then explore left subtree
        if(p.val < root.val && q.val<root.val){
            return lowestCommonAncestor( root.left,  p,  q);
        }//if p and q are greter than root, then explore right subtree
        else if(p.val > root.val && q.val > root.val){
             return lowestCommonAncestor( root.right,  p,  q);
        }else{//else root is the smallest common ancestor
            return root;
        }
    }
}