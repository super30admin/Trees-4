// Time Complexity : O(log n), where n is the number of nodes in the tree
// Space Complexity :O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
        
        while(root != null){
            //if p and q are smaller than root, then explore left subtree
            if(p.val < root.val && q.val<root.val){
             root = root.left;
            }//if p and q are greter than root, then explore right subtree
            else if(p.val > root.val && q.val > root.val){
              root = root.right;
            }else{//else root is the smallest common ancestor
                return root;
            }
        }
        return null;
    }
}